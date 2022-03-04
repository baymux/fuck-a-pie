package com.sjft.utils.page;

import com.sjft.common.StringUtils;
import lombok.Data;

/**
 * 分页数据
 *
 * @author lzg
 * @date 2020年8月10日18:00:34
 */
@Data
public class PageDomain {
    /**
     * 当前记录起始索引
     */
    private Integer pageNum = 1;
    /**
     * 每页显示记录数
     */
    private Integer pageSize = 10;
    /**
     * 排序列
     */
    private String orderByColumn;
    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    private String isAsc;

    public String getOrderBy() {
        if (StringUtils.isEmpty(orderByColumn)) {
            return "";
        }
        return StringUtils.toUnderScoreCase(orderByColumn) + " " + isAsc;
    }

}
