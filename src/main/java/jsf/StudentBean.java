package jsf;
import domain.StudentDomain;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import static net.bootsfaces.component.ComponentsEnum.alert;

@ManagedBean
@SessionScoped

public class StudentBean {

    private String email;
    private String password;


//    public String checkLogin(){
//
//        if((email==email)&&(password==password) ){
//           return "studentpage1";
//        }
//        else{
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("You are not authorized."));
//        return "studentLogin";
//    }

    public String checkLogin() {
        System.out.println("In studentbean, login check");
//        if((getEmail()==getEmail())&&(getPassword()==getPassword())){
//            System.out.println("In the if condition");
//            return "studentpage1";
//        }
//        else{
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("You are not authorized."));
//            System.out.println("In the else condition");
//            return "studentlogin";
//        }
        return "j001";
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}