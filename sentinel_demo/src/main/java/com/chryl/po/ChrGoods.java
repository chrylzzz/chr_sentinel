package com.chryl.po;

import lombok.Data;

import java.time.LocalDate;

/**
 * Created by Chr.yl on 2020/6/10.
 *
 * @author Chr.yl
 */
@Data
public class ChrGoods {
    private Integer goodsId;

    private String goodsName;

    private String goodsPrice;

    private LocalDate releaseDate;

    private String goodsColor;

    private String goodsType;

    private String goodsStatus;

    private Integer goodsImp;

    private String goodsDesc;

    private Integer goodsStock;
}
