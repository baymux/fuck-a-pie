package com.sjft.utils.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.sjft.common.StringUtils;
import com.sjft.common.SysHttpStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 表格分页数据对象
 *
 * @author lzg
 * @date 2020年8月10日18:00:34
 */
@Data
public class TableDataInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 列表数据
     */
    private T data;

    /**
     * 消息状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 表格数据对象
     */
    public TableDataInfo() {
    }

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public TableDataInfo(T list, int total) {
        this.data = list;
        this.total = total;
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static TableDataInfo getDataTable(List data) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(SysHttpStatus.OK.value());
        rspData.setData(data);
        rspData.setTotal(new PageInfo(data).getTotal());
        rspData.setMsg("操作成功");
        return rspData;
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static TableDataInfo setData(TableDataInfo tableDataInfo, List data) {
        tableDataInfo.setData(data);
        return tableDataInfo;
    }

    /**
     * @Description 分页
     * @author lzg
     * @date f 21:44
     * @Param []
     * @return void
     **/
    public static void startPage(){
        com.sjft.utils.page.PageDomain pageDomain = com.sjft.utils.page.TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize)) {
            PageHelper.startPage(pageNum, pageSize, pageDomain.getOrderBy());
        }
    }
}
