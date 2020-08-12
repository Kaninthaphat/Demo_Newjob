package view;

import java.sql.ResultSet;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Vlayout;

import connect.SqlSelection;

public class view_index extends Vlayout{

	private static final long serialVersionUID = 1L;
	private Session session ;
	

	public void newTab(String StrUrl,String StrName,String ImagesPath) {   	
    	
        Tab tb = new Tab();
        tb.setLabel(StrName);
        tb.setClosable(true);   
        tb.setImage(ImagesPath);
        ((Tabs) getFellow("Tabs")).appendChild(tb);

        tb.setSelected(true);
        StrUrl = StrUrl.replace('?', '&');
        StrUrl = StrUrl.replace("zul&", "zul?");

        Iframe ifm = new Iframe(StrUrl);
        ifm.setScrolling("auto");
        ifm.setHeight("100%");
        ifm.setWidth("100%");

        Tabpanel tp = new Tabpanel();
        tp.appendChild(ifm);
        ((Tabpanels) getFellow("Tabpanels")).appendChild(tp);
        
        ((Vlayout) getFellow("t")).setVisible(false);
        
        session = Sessions.getCurrent();
        session.setAttribute("session_costid",0);
        
    }
	
	public void OnSelect_Menu(String url,String name,String images_path,int login_type,int menu_id) {
		
		session = Sessions.getCurrent();
		
		if(session.getAttribute("session_PersonCode") == null){		
			Executions.sendRedirect("login.zul");
		}else{
			if(login_type == 1){//Reques Login=1 None=0
			   
				if(load_role_user(menu_id)==false){
				   Messagebox.show("Permissstion False!", "Warning", Messagebox.OK, Messagebox.ERROR);				  
			    }else{
				   newTab(url,name,images_path);
			    }
			}else{
				newTab(url,name,images_path);
			}
	    }	
	}
	
	public void home_select(){
		Executions.sendRedirect("index.zul");
	}
	
	public boolean load_role_user(int menu)
	{		
		boolean return_type = false;
		
		ResultSet rs_ = null;
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [999_PERMISSTION_CHECK] @Usercode='"+session.getAttribute("session_PersonCode")+"',@menu_id = '"+menu+"'";	
       
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);  
        	
            while (rs_.next()) {
            	return_type = true;
            }
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				sqlsel.closeConnection();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
		return return_type;
	}
	
	
}
