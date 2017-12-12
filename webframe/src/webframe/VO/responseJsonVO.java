
package webframe.VO;

import java.util.ArrayList;
import java.util.List;

public class responseJsonVO {
	public responseJsonHeaderVO HEADER;
	public List<Object> DATA;

	public responseJsonVO() {
		HEADER = new responseJsonHeaderVO();
		DATA = new ArrayList<Object>();
	}
}
