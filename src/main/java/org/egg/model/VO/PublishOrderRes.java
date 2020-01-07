package org.egg.model.VO;

import lombok.Data;
import org.egg.model.DO.PubOrder;

import java.io.Serializable;

/**
 * Created by chendatao on 2017/12/10.
 */
@Data
public class PublishOrderRes  extends PubOrder implements Serializable {
    private String statusStr;
}
