<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<script>
    $(function() {
//        var datagrid = $("#dxsNewsListtb");
//        console.log(datagrid);
    });
</script>

<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="dxsNewsList" checkbox="true" fitColumns="false" title="新闻列表"
                    actionUrl="dxsNewsController.do?datagrid" idField="id" fit="true" queryMode="group"
                    sortName="newPublishTime" sortOrder="desc">
            <t:dgCol title="主键" field="id" hidden="false" query="true" width="225"></t:dgCol>
            <t:dgCol title="新闻分类" field="dxsNewsCatelogEntity.newCatelogName" query="true" width="60"></t:dgCol>
            <t:dgCol title="新闻标题" field="newTitle" query="true" width="300"></t:dgCol>
            <t:dgCol title="编辑人" field="newEditor" query="true" width="48"></t:dgCol>
            <t:dgCol title="新闻来源" field="newFrom" queryMode="group" width="60"></t:dgCol>
            <t:dgCol title="发布时间" field="newPublishTime" formatter="yyyy-MM-dd" queryMode="group" width="72"></t:dgCol>
            <t:dgCol title="新闻发布年份" field="newPublishYear" queryMode="group" width="82"></t:dgCol>
            <t:dgCol title="是否特别关注" field="isSpecial" queryMode="group" width="82" formatterjs="DXS.isSpecial" align="center"></t:dgCol>
            <%--<t:dgCol title="新闻内容"  field="newContents"    queryMode="group"  width="120"></t:dgCol>--%>
            <%--<t:dgCol title="编号" field="newSort" queryMode="group" width="36"></t:dgCol>--%>
            <%--<t:dgCol title="createTime"  field="createTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
            <%--<t:dgCol title="updateTime"  field="updateTime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>--%>
            <%--<t:dgCol title="删除标志"  field="isDelete"    queryMode="group"  width="120"></t:dgCol>--%>
            <t:dgCol title="操作" field="opt" width="130"></t:dgCol>
            <t:dgDelOpt title="删除" url="dxsNewsController.do?doDel&id={id}"/>
            <t:dgConfOpt message="确认操作？" title="设为特别关注" url="dxsNewsController.do?doUpdate&isSpecial=1&id={id}"/>
            <t:dgToolBar title="录入" icon="icon-add" url="dxsNewsController.do?goAdd" funname="add"
                         height="720" width="1120"></t:dgToolBar>
            <t:dgToolBar title="编辑" icon="icon-edit" url="dxsNewsController.do?goUpdate" funname="update"
                         height="720" width="1120"></t:dgToolBar>
            <t:dgToolBar title="批量删除" icon="icon-remove" url="dxsNewsController.do?doBatchDel"
                         funname="deleteALLSelect"></t:dgToolBar>
            <t:dgToolBar title="查看" icon="icon-search" url="dxsNewsController.do?goUpdate"
                         funname="detail"  height="720" width="1120"></t:dgToolBar>
            <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
            <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
            <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
        </t:datagrid>
    </div>
</div>
<script type="text/javascript">
    var DXS = {
        isSpecial: function (value, row, index) {
            if (value == "1") {
                return "<span style='color:#ff3335'>是</span>";
            } else if (value == "0") {
                return "否";
            } else {
                return value;
            }
        }
    }
    $(document).ready(function () {
        //给时间控件加上样式
        $("#dxsNewsListtb").find("input[name='newPublishTime_begin']").attr("class", "Wdate").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });
        $("#dxsNewsListtb").find("input[name='newPublishTime_end']").attr("class", "Wdate").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });
        $("#dxsNewsListtb").find("input[name='createTime_begin']").attr("class", "Wdate").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });
        $("#dxsNewsListtb").find("input[name='createTime_end']").attr("class", "Wdate").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });
        $("#dxsNewsListtb").find("input[name='updateTime_begin']").attr("class", "Wdate").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });
        $("#dxsNewsListtb").find("input[name='updateTime_end']").attr("class", "Wdate").click(function () {
            WdatePicker({dateFmt: 'yyyy-MM-dd'});
        });
    });

    //导入
    function ImportXls() {
        openuploadwin('Excel导入', 'dxsNewsController.do?upload', "dxsNewsList");
    }

    //导出
    function ExportXls() {
        JeecgExcelExport("dxsNewsController.do?exportXls", "dxsNewsList");
    }

    //模板下载
    function ExportXlsByT() {
        JeecgExcelExport("dxsNewsController.do?exportXlsByT", "dxsNewsList");
    }
</script>