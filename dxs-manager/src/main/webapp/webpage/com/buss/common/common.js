
var DXSuser = {
    userCheck : function(value, row, index){
        if (value == "0" || value == "9" || value == "3" || value == "6") {
            return "<span style='color:#ff3335'>未审核</span>";
        } else if(value == "4" || value == "7" || value=="10"){
            return "已同意";
        } else if(value==2|| value=="5" || value=="8"){
            return "已拒绝";
        } else {
            return value;
        }
    }
}

//============================杨治国======================================================
/*创业基金审核码*/
var yzg = {
    foundation : function(value, row, index){
        if (value == "0"){
            return "<span style='color:#010305'>待审核</span>";
        }else if(value == "5"){
            return "审核中";
        }else if(value == "10"){
            return "审核通过";
        }else if (value == "15"){
            return "审核失败";
        }else {
            return value;
        }
    }
}

/*创业基金申请类型*/
var type = {
    applicationType : function(value, row,index){
        if (value == "3"){
            return "<span style='color:#010305'>创业基金</span>";
        }else if (value == "4"){
            return "创业基地";
        }else {
            return value;
        }
    }
}
/*创业基金和创业基地的判断*/
var DXSActive = {
    Active : function(value, row,index){
        if (value == "0"){
            return "<span style='color:#010305'>未审核</span>";
        }else if (value == "3"){
            return "已通过";
        }else if(value == "4"){
            return "已拒绝";
        }else {
            return value;
        }
    }
}

/*项目等级*/
var project = {
    grade :function(value,row,index){
        if (value == "0"){
            return "<span style='color:#010305'>校级</span>";
        }else if (value == "1"){
            return "市级";
        }else if (value == "2"){
            return "省级";
        }else if (value == "3"){
            return "全国总觉赛";
        }else if (value == "4"){
            return "大区级";
        }else {
            return value;
        }
    }
}

/*项目状态*/
var project1= {
    status :function(value,row,index){
        if (value == "0"){
            return "<span style='color:#010305'>未获投资</span>";
        }else if (value == "1"){
            return "已获投资";
        }else {
            return value;
        }
    }
}
// ==================================================================================================================
//活动
var DXActives = {
    Actives : function(value, row,index){
        if (value == "1"){
            return "<span style='color:#ff3335'>否</span>";
        }else if (value == "0"){
            return "是";
        }else  {
            return value;
        }
    }
}



//奖金发布
var DXSType = {
    Type : function(value, row,index){
        if (value == "1"){
            return "奖学金";
        }else if (value == "2"){
            return "助学金";
        }else {
            return value;
        }
    }
}
//奖金申请
var DXS = {
    TextType : function(value, row,index){
        if (value == "1"){
            return "一等奖";
        }else if (value == "2"){
            return "二等奖";
        }else if(value == "3"){
            return "三等奖";
        }else {
            return value;
        }
    }
}
var DX = {
    Checkcode: function (value, row, index) {
        if (value == "0") {
            return "<span style='color:#ff3335'>未审核</span>";
        } else if (value == "3") {
            return "已通过";
        } else if (value == "4") {
            return "已拒绝";
        } else {
            return value;
        }
    }

}
var D = {
    ApplyType: function (value, row, index) {
        if (value == "1") {
            return "奖学金";
        } else if (value == "2") {
            return "助学金";
        }  else {
            return value;
        }
    }
}
