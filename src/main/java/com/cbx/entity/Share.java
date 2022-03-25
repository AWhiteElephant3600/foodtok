package com.cbx.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author author:cbx
 * @since 2022-03-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Share extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer userid;

    private String message;

    private String time;


}
