package jsf;


import org.eclipse.persistence.annotations.CompositeMember;

import javax.faces.component.FacesComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Scope;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

//@Component
//@Scope ("request")
public class SpringLoginBean {

    private String user;
    private String password;
    private boolean storeUser= false;
    private boolean logIn = false;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStoreUser() {
        return storeUser;
    }

    public void setStoreUser(boolean storeUser) {
        this.storeUser = storeUser;
    }

    public boolean isLogIn() {
        return logIn;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }

    public String loginAction() throws IOException, ServletException
    {
        ExternalContext context =
                FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest)context.getRequest()).getRequestDispatcher(
                "/j_spring_security_check");
        dispatcher.forward((ServletRequest)context.getRequest(),(ServletResponse)context.getResponse()) ;
        return null;
    }
}
