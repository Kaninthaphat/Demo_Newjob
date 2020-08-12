package applications2;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.ListModelList;

import connect.SqlSelection;
import general.DateTime;
import model.model_meeting;
import model.model_telphone;
import model.model_topNg;

public class NavbarComposer{
	
	private Date startDate;
	private Date endDate;
	private String startDate_string;
	private String endDate_string;
	private String meeting_date;
	private int countmeeting = 0;
	private int count_ng = 0;
	private int c_day ;
	private String meeting_date_String ;
	
	private List<model_topNg> model_list_item;
	private List<model_meeting> model_list_meeting;
	private ListModelList<model_telphone>model_list_telphone;
	
	private Session session ;
	private String user_login = "";
	private String profile_login = "";
	
    private String searchValue = "";
	private String AreaValue = "";
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getUser_login() {
		return user_login;
	}

	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}

	public String getProfile_login() {
		return profile_login;
	}

	public void setProfile_login(String profile_login) {
		this.profile_login = profile_login;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartDate_string() {
		return startDate_string;
	}

	public void setStartDate_string(String startDate_string) {
		this.startDate_string = startDate_string;
	}

	public String getEndDate_string() {
		return endDate_string;
	}

	public void setEndDate_string(String endDate_string) {
		this.endDate_string = endDate_string;
	}

	public List<model_topNg> getModel_list_item() {
		return model_list_item;
	}

	public void setModel_list_item(List<model_topNg> model_list_item) {
		this.model_list_item = model_list_item;
	}

	public List<model_meeting> getModel_list_meeting() {
		return model_list_meeting;
	}

	public void setModel_list_meeting(List<model_meeting> model_list_meeting) {
		this.model_list_meeting = model_list_meeting;
	}

	public int getCountmeeting() {
		return countmeeting;
	}

	public void setCountmeeting(int countmeeting) {
		this.countmeeting = countmeeting;
	}

	public int getCount_ng() {
		return count_ng;
	}

	public void setCount_ng(int count_ng) {
		this.count_ng = count_ng;
	}

	public ListModelList<model_telphone> getModel_list_telphone() {
		return model_list_telphone;
	}

	public void setModel_list_telphone(ListModelList<model_telphone> model_list_telphone) {
		this.model_list_telphone = model_list_telphone;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getAreaValue() {
		return AreaValue;
	}

	public void setAreaValue(String areaValue) {
		AreaValue = areaValue;
	}

	public String getMeeting_date() {
		return meeting_date;
	}

	public void setMeeting_date(String meeting_date) {
		this.meeting_date = meeting_date;
	}

	public int getC_day() {
		return c_day;
	}

	public void setC_day(int c_day) {
		this.c_day = c_day;
	}

	public String getMeeting_date_String() {
		return meeting_date_String;
	}

	public void setMeeting_date_String(String meeting_date_String) {
		this.meeting_date_String = meeting_date_String;
	}

	@Init
	public void init() {
		  System.out.println("@Init"); 
		  session = Sessions.getCurrent();
		  if (session.getAttribute("session_PersonCode") == null) {				
				user_login= "";
				profile_login = "";
		  } else {				
				user_login =  session.getAttribute("session_PersonCode").toString();
				profile_login =  session.getAttribute("session_PersonProfile").toString();	
				
	      }
	}
	
	@SuppressWarnings("deprecation")
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		System.out.println("@AfterCompose"); 
		
		Calendar c = Calendar.getInstance();
		endDate = c.getTime();
		c_day = c.getTime().getDate();
		c.set(Calendar.DAY_OF_MONTH, 1);				
		startDate = c.getTime();
		
		startDate_string = DateTime.set_DateString(startDate);
		endDate_string = DateTime.set_DateString(endDate);
		meeting_date = DateTime.set_DateString_f2(endDate);
		meeting_date_String = "Meeting Rooms Date:"+meeting_date;
		
		//load_ng();
		load_phone();
    }
	
	
	public void load_ng()
	{
		ResultSet rs_ = null;
        List<model_topNg> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [701_TOP5_NG] @START_DATE = '"+startDate_string+"',"
        		+ "@END_DATE = '"+endDate_string+"' ";
        
        System.out.println(StrSQL);
        
        int i = 1;
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);
            while (rs_.next()) {
            	                 
		            double dif_am = 0;	
		            dif_am = rs_.getDouble("ng_persen") - rs_.getDouble("target_down");
	            	
		            model_topNg model = new model_topNg();    
		            	model.setRownumber(i);
		            	model.setItem_product_group(rs_.getString("product_group"));  
		            	model.setNg_qty(rs_.getDouble("ng_qty"));
		            	model.setFg_qty(rs_.getDouble("fg_qty"));
		            	model.setNg_persen(rs_.getDouble("ng_persen"));
		            	model.setNg_perString(rs_.getString("ng_persen")+"%");
		            	model.setTarget_downS(rs_.getString("target_down")+"%");
		            	model.setNg_difS(formatSring(dif_am+"")+"%");
		            	
		            	if(dif_am > 0){
		            		model.setStyle_name("color:#CC3300;font-size:12px;text-align:center;");
		            	}
		            	else if(dif_am == 0){
			            		model.setStyle_name("color:#3300cc;font-size:12px;text-align:center;");
			            
		            	}
		            	else{
		            		model.setStyle_name("color:#333333;font-size:12px;text-align:center;");
		            	}
		            	
		            	model_list.add(model); 
		            	
		            	i++;
		            	count_ng+=1;           
           }
            model_list_item = new ListModelList<model_topNg>(model_list);
                     
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				sqlsel.closeConnection();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	public static String formatSring(String stock) {
		  NumberFormat formatter = new DecimalFormat("#,##0.00");             
	      return formatter.format(Double.valueOf(stock).doubleValue());
	}
	
	@Command
	@NotifyChange("*")
	public void link_host_meeting() throws IOException{
		Executions.getCurrent().sendRedirect("http://192.168.2.18/meeting_room/index.php", "_blank");
	}
	
	@Command
 	@NotifyChange("*")
 	public void view_link() throws Exception {
		URI openIt=new URL("http://119.59.122.80:8080/SUS_BID/").toURI();
		java.awt.Desktop.getDesktop().browse(openIt);	
	}

	@Command
	@NotifyChange("*")
	public void load_phone()
	{

		ResultSet rs_ = null;
        List<model_telphone> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [SUS_NUMBERPHONE] @Area = '"+AreaValue+"' ,@search='"+searchValue+"'";
        //System.out.println(StrSQL);
        int i=1;
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);
            while (rs_.next()) {
            	model_telphone model = new model_telphone();    
            	
            	model.setRow_number(i);
            	model.setId_phone(rs_.getInt("Id_phone"));  
            	model.setDepartment_Name(rs_.getString("Department_Name"));
            	model.setArea_phone(rs_.getString("area_phone"));
            	model.setNo_phone(rs_.getString("No_phone"));
            	model.setContact_phone(rs_.getString("Contact_phone"));
            	      
            	
            	model_list.add(model);  
            	i++;
            
            }
            model_list_telphone = new ListModelList <model_telphone>(model_list);
            setModel_list_telphone(model_list_telphone);           
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				sqlsel.closeConnection();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}	

}
