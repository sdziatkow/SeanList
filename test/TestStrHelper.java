
import org.junit.Test;
import static org.junit.Assert.*;
import seanList.*;

public class TestStrHelper {
    private SeanList<String> strSList;
    private SeanList<String> strSListAsc;
    private SeanList<String> strSListDesc;


    private void makeLists() {
        strSList = new GenericSList<>();
        strSList.addLast("sean");
        strSList.addLast("olivia");
        strSList.addLast("ryan");
        strSList.addLast("joe");

        strSListAsc = new GenericSList<>();
        strSListAsc.addLast("joe");
        strSListAsc.addLast("olivia");
        strSListAsc.addLast("ryan");
        strSListAsc.addLast("sean");

        strSListDesc = new GenericSList<>();
        strSListDesc.addLast("sean");
        strSListDesc.addLast("ryan");
        strSListDesc.addLast("olivia");
        strSListDesc.addLast("joe");
    }

    @Test
    public void testSortAsc() {
        makeLists();
        strSList.print();
        StrHelper.sort(strSList, StrHelper.SortOrder.ASC);
        strSList.print();
        strSListAsc.print();
    }

    @Test
    public void testSortDesc() {
        makeLists();
        strSList.print();
        StrHelper.sort(strSList, StrHelper.SortOrder.DESC);
        strSList.print();
        strSListDesc.print();
    }
}
