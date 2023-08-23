import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

public class maintest {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BeanManager bm = container.getBeanManager();
        Bean<service> bean = (Bean<service>) bm.getBeans("aaa").iterator().next();
        CreationalContext<service> ctx = bm.createCreationalContext(bean);
        service jdbc = (service) bm.getReference(bean, service.class, ctx);
        jdbc.test();
    }
}
