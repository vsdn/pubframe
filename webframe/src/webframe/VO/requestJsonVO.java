package webframe.VO;

import java.util.ArrayList;
import java.util.List;

public class requestJsonVO {
	public requestJsonHeaderVO HEADER;
	public List<Object> DATA;

	public requestJsonVO() {
		HEADER = new requestJsonHeaderVO();
		DATA = new ArrayList<Object>();
	}
	
}
