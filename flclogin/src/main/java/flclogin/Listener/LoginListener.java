package flclogin.Listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoginListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //监听器，session建立时在线人数增加1
        System.out.println("建立一个连接" + httpSessionEvent.getSession().getId());
        ServletContext context=httpSessionEvent.getSession().getServletContext();
        Integer onlinecount=(Integer) context.getAttribute("onlinecount");
        if(onlinecount==null)
            onlinecount=-2;
        onlinecount=onlinecount+1;
        context.setAttribute("onlinecount",onlinecount);
        System.out.println("onlinecount: "+onlinecount );
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //监听器，session销毁时在线人数减少1
        System.out.println("断开一个链接" + httpSessionEvent.getSession().getId());
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        Integer onlinecount = (Integer) context.getAttribute("onlinecount");
        onlinecount=onlinecount-1;
        context.setAttribute("onlinecount", onlinecount  );
        System.out.println("onlinecount: " + onlinecount);
    }


}
