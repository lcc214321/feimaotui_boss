package org.egg.model.VO;

import lombok.Data;
import org.egg.model.DO.AcceptOrder;

import java.io.Serializable;

/**
 * @author cdt
 * @Description
 * @date: 2018/3/6 18:15
 */
@Data
public class AcceptOrderRes  extends AcceptOrder implements Serializable {

    private String orderStatusStr;


}
