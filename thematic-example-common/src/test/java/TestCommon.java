import com.yulintu.thematic.JavaTypeConverter;
import org.junit.Test;

public class TestCommon {

    @Test
    public void testConverter() {

        JavaTypeConverter converter = new JavaTypeConverter();

        System.out.println(converter.to(int.class, "432"));
    }
}
