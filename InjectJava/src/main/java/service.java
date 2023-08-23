import javax.inject.Inject;
import javax.inject.Named;

@Named("aaa")
public class service {
    @Inject
    private IMethod user;
    public void test(){
        user.hello();
    }
}
