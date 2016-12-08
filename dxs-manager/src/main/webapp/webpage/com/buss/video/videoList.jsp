
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--jQuery File Upload. Created by wupan on 2016/7/22. -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>文件上传</title>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="http://oss.devcp.org/js/css/upload/jquery.fileupload.css">
    <link rel="stylesheet" href="http://oss.devcp.org/js/css/upload/index.css">
    <style type="text/css">
        .column-date {  width: 135px;  text-align: right;  }
    </style>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://oss.devcp.org/js/jquery-ui/1.10.4/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="http://oss.devcp.org/js/jquery/plugin/jquery.jeditable.js"></script>
    <!--jQuery File Upload核心类-->
    <script type="text/javascript" src="http://oss.devcp.org/js/jquery/plugin/jquery.fileupload.js"></script>
    <!--扩展iframe数据传输-->
    <script type="text/javascript" src="http://oss.devcp.org/js/jquery/plugin/jquery.iframe-transport.js"></script>
    <script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://oss.devcp.org/js/jquery/plugin/tmpl.min.js"></script>
    <script type="text/javascript" src="http://oss.devcp.org/js/common/tool.js"></script>
    <script type="text/javascript">
        /*  默认接口请求地址*/

        var req_url = "http://118.178.25.3:999/oss/";

        var _bucket = ""; /*  默认Bucket*/
        var _accessUrl = "";

        _bucket = "csee-china";
        _accessUrl = "http://"+_bucket+".oss-cn-beijing.aliyuncs.com";

        var _param = getSearchParam('u'); /* url后面的参数 ?u=csee */
        if( _param != ''){
            _bucket = _param;
        }
        var _device = "/" +　_bucket;
    </script>
    <!--<script src="http://oss.devcp.org/js/other/index.js"></script>-->
    <script type="text/javascript">
        /*
         文件上传主要用到的JS，可根据自身需求定制
         */
        var ENTER_KEYCODE = 13;

        var _path = null;
        var _pendingReloads = [];
        var _reloadingDisabled = 0;

        /*
         * 文件大小转换成可显示的Mb,Gb和kb方法 */
        function formatFileSize(size) {
            var kb = 1024;
            var mb = kb * 1024;
            var gb = mb * 1024;
            if (size >= gb) {
                return (size / gb).toFixed(2) + ' GB';
            } else if (size >= mb) {
                return (size / mb).toFixed(2) + ' MB';
            } else
                return (size / kb).toFixed(2) + ' KB';
        }

        function _showSuccess(message, textStatus, elasticTitle) {
            $("#alerts").prepend(tmpl("template-alert", {
                level: "success",
                title: (elasticTitle != "" ? elasticTitle : textStatus) + ": ",
                description: message
            }));
        }

        function _showError(message, textStatus, errorThrown) {
            $("#alerts").prepend(tmpl("template-alert", {
                level: "danger",
                title: (errorThrown != "" ? errorThrown : textStatus) + ": ",
                description: message
            }));
        }

        function _disableReloads() {
            _reloadingDisabled += 1;
        }

        function _enableReloads() {
            _reloadingDisabled -= 1;

            if (_pendingReloads.length > 0) {
                _reload(_pendingReloads.shift());
            }
        }

        function _reload(path) {
            if (_reloadingDisabled) {
                if ($.inArray(path, _pendingReloads) < 0) {
                    _pendingReloads.push(path);
                }
                return;
            }

            _disableReloads();

            $.ajax({
                url: req_url + 'list',
                data: { path: path, bucket:_bucket },
                dataType: 'json'
            }).fail(function(jqXHR, textStatus, errorThrown) {
                _showError("Failed retrieving contents of \"" + path + "\"", textStatus, errorThrown);
            }).done(function(data, textStatus, jqXHR) {
                var scrollPosition = $(document).scrollTop();

                if (path != _path) {
                    $("#path").empty();
                    if (path == "/") {
                        $("#path").append('<li class="active">' + _device + '</li>');
                    } else {
                        $("#path").append('<li data-path="/"><a>' + _device + '</a></li>');
                        var components = path.split("/").slice(1, -1);
                        for (var i = 0; i < components.length - 1; ++i) {
                            var subpath = "/" + components.slice(0, i + 1).join("/") + "/";
                            $("#path").append('<li data-path="' + subpath + '"><a>' + components[i] + '</a></li>');
                        }
                        $("#path > li").click(function(event) {
                            _reload($(this).data("path"));
                            event.preventDefault();
                        });
                        $("#path").append('<li class="active">' + components[components.length - 1] + '</li>');
                    }
                    _path = path;
                }

                $("#listing").empty();
                for (var i = 0, file; file = data[i]; ++i) {
                    $(tmpl("template-listing", file)).data(file).appendTo("#listing");
                }

                $(".edit").editable(function(value, settings) {
                    var name = $(this).parent().parent().data("name");
                    if (value != name) {
                        var path = $(this).parent().parent().data("path");
                        $.ajax({
                            url: 'move',
                            type: 'POST',
                            data: {
                                oldPath: path,
                                newPath: _path + value
                            },
                            dataType: 'json'
                        }).fail(function(jqXHR, textStatus, errorThrown) {
                            _showError("Failed moving \"" + path + "\" to \"" + _path + value + "\"", textStatus, errorThrown);
                        }).always(function() {
                            _reload(_path);
                        });
                    }
                    return value;
                }, {
                    onedit: function(settings, original) {
                        _disableReloads();
                    },
                    onsubmit: function(settings, original) {
                        _enableReloads();
                    },
                    onreset: function(settings, original) {
                        _enableReloads();
                    },
                    tooltip: 'Click to rename...'
                });

                // Ajax 文件下载
                jQuery.download = function(url, data, method){    // 获得url和data
                    /*console.log(url);*/
                    if( url ){
                        // data 是 string 或者 array/object
                        data = typeof data == 'string' ? data : jQuery.param(data);
                        // 把参数组装成 form的  input
                        var inputs = '';
                        jQuery.each(data.split('&'), function(){
                            var pair = this.split('=');
                            inputs+='<input type="hidden" name="'+ pair[0] +'" value="'+ pair[1] +'" />';
                        });
                        // request发送请求
                        jQuery('<form action="'+ url +'" method="'+ (method||'post') +'">'+inputs+'</form>')
                                .appendTo('body').submit().remove();
                    };
                };

                $(".button-download").click(function(event) {
                    var path = $(this).parent().parent().data("path");
                    var req_down_url = req_url + "download.do?path="+encodeURIComponent(path)+"&url="
                            + encodeURIComponent(_accessUrl);
                    setTimeout(function() {
                        window.location = req_down_url;

                    }, 0);
                });

                $(".button-open").click(function(event) {
                    var path = $(this).parent().parent().data("path");
                    _reload(path);
                });

                $(".button-move").click(function(event) {
                    var path = $(this).parent().parent().data("path");
                    if (path[path.length - 1] == "/") {
                        path = path.slice(0, path.length - 1);
                    }
                    $("#move-input").data("path", path);
                    $("#move-input").val(path);
                    $("#move-modal").modal("show");
                });

                $(".button-popover").click(function(event) {
                    var path = $(this).parent().parent().data("path");
                    $.ajax({
                        url: req_url + 'generate_sign_url.do',
                        type: 'POST',
                        crossDomain: true,
                        data: {path: path},
                        dataType: "json",
                    }).done(function ( data ) {
                        _showSuccess(_accessUrl + data, data.textStatus, path+" 地址");
                    });
                });
                $(".button-view").click(function(event) {
                    event.preventDefault();
                    var path = $(this).parent().parent().data("path");
                    $.ajax({
                        url: req_url + 'generate_sign_url.do',
                        type: 'POST',
                        crossDomain: true,
                        data: {path: path},
                        dataType: "json",
                    }).done(function ( data ) {
                        setTimeout(function() {
                            if(_bucket=="oss-devcp-org"){
                                url = "http://oss.devcp.org";
                            }
                            var fileUrl = _accessUrl + data;
                            /* .md */
                            var index = data.toString().lastIndexOf('.');
                            var strtype = data.toString().substr(index,3);
                            strtype = strtype.toLowerCase();
//                            console.log("index="+index+" ,strtype="+strtype);
                            if(strtype == ".md"){
                                fileUrl = "http://md.devcp.org/preview.html?p=" + fileUrl;
                            }

                            var tempwindow=window.open('_blank');
                            tempwindow.location=fileUrl;
                        }, 0);
                    });
                });

                $(".button-delete").click(function(event) {
//                    _showError("无权删除文件！", "", "ERROR");

                     var path = $(this).parent().parent().data("path");
                     $.ajax({
                     url: req_url + 'delete',
                     type: 'POST',
                     crossDomain: true,
                     data: {path: path, bucket:_bucket},
                     dataType: "json",
                     }).fail(function(jqXHR, textStatus, errorThrown) {
                     _showError("Failed deleting \"" + path + "\"", textStatus, errorThrown);
                     }).always(function() {
                     _reload(_path);
                     });
                });

                $(document).scrollTop(scrollPosition);
            }).always(function() {
                _enableReloads();
            });
        }

        $(document).ready(function() {

            try {
                var browser = navigator.appName
                var b_version = navigator.appVersion
                var version = b_version.split(";");
                var trim_Version = version[1].replace(/[ ]/g, "");
                if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE6.0") {
                    alert("您的浏览器版本过低，请升级您的浏览器！");
                } else if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE7.0") {
                    alert("您的浏览器版本过低，请升级您的浏览器！");
                }
            } catch (e) {} finally {}
            // Workaround Firefox and IE not showing file selection dialog when clicking on "upload-file" <button>
            // Making it a <div> instead also works but then it the button doesn't work anymore with tab selection or accessibility
            $("#upload-file").click(function(event) {
                $("#fileupload").click();
            });

            // Prevent event bubbling when using workaround above
            $("#fileupload").click(function(event) {
                event.stopPropagation();
            });
            //初始化，主要是设置上传参数，以及事件处理方法(回调函数)
            $("#fileupload").fileupload({
                dropZone: $(document),
                pasteZone: null,
                autoUpload: true, //是否自动上传
                sequentialUploads: true,
                // limitConcurrentUploads: 2,
                // forceIframeTransport: true,
                // 文件上传地址
                url: req_url + 'upload.do',
                type: 'POST',
                crossDomain: true,
                dataType: "json",

                start: function(e) {
                    $(".uploading").show();
                },

                stop: function(e) {
                    $(".uploading").hide();
                },

                add: function(e, data) {
                    var file = data.files[0];
                    data.formData = {path:_path, bucket:_bucket}; //如果需要额外添加参数可以在这里添加
                    data.context = $(tmpl("template-uploads", {
                        path: _path + file.name
                    })).appendTo("#uploads");
                    var jqXHR = data.submit();
                    data.context.find("button").click(function(event) {
                        jqXHR.abort();
                    });
                },

                progress: function(e, data) {
                    var progress = parseInt(data.loaded / data.total * 100, 10);
                    data.context.find(".progress-bar").css("width", progress + "%");
                },

                done: function(e, data) { //设置文件上传完毕事件的回调函数
                    _reload(_path);
//                    console.log(data);
//                    alert(data.result);
                    _showSuccess("文件上传成功，地址为："+ data.result, data.textStatus, "");
                },

                fail: function(e, data) {
                    var file = data.files[0];
                    if (data.errorThrown != "abort") {
                        _showError(file.name + ":不支持的文件格式", data.textStatus, data.errorThrown);
                    }
                },

                always: function(e, data) {
                    data.context.remove();
                },

            });

            $("#create-input").keypress(function(event) {
                if (event.keyCode == ENTER_KEYCODE) {
                    $("#create-confirm").click();
                };
            });

            $("#create-modal").on("shown.bs.modal", function(event) {
                $("#create-input").focus();
                $("#create-input").select();
            });

            $("#create-folder").click(function(event) {
                $("#create-input").val("Untitled folder");
                $("#create-modal").modal("show");
            });

            $("#create-confirm").click(function(event) {
                $("#create-modal").modal("hide");
                var name = $("#create-input").val();
                if (name != "") {
                    $.ajax({
                        url: req_url + 'create.do',
                        type: 'POST',
                        crossDomain: true,
//                        data: {path: _path + name, bucket:_bucket},
                        data: {path: _path, name: name, bucket:_bucket},
                        dataType: "json",
//                    }).done(function() { alert("success");
                    }).fail(function(jqXHR, textStatus, errorThrown) {
                        _showError("Failed creating folder \"" + name + "\" in \"" + _path + "\"", textStatus, errorThrown);
                    }).always(function() {
                        _reload(_path);
                    });
                }
            });

            $("#move-input").keypress(function(event) {
                if (event.keyCode == ENTER_KEYCODE) {
                    $("#move-confirm").click();
                };
            });

            $("#move-modal").on("shown.bs.modal", function(event) {
                $("#move-input").focus();
                $("#move-input").select();
            })

            $("#move-confirm").click(function(event) {
                $("#move-modal").modal("hide");
                var oldPath = $("#move-input").data("path");
                var newPath = $("#move-input").val();
                if ((newPath != "") && (newPath[0] == "/") && (newPath != oldPath)) {
                    $.ajax({
                        url: 'move',
                        type: 'POST',
                        data: {
                            oldPath: oldPath,
                            newPath: newPath
                        },
                        dataType: 'json'
                    }).fail(function(jqXHR, textStatus, errorThrown) {
                        _showError("Failed moving \"" + oldPath + "\" to \"" + newPath + "\"", textStatus, errorThrown);
                    }).always(function() {
                        _reload(_path);
                    });
                }
            });

            $("#reload").click(function(event) {
                _reload(_path);
            });

            _reload("/");

        });
    </script>
</head>
<body>

<div class="container">

    <div class="page-header">
        <h1><center>文件上传<center></h1>
    </div>

    <div id="alerts"></div>

    <div class="btn-toolbar">
        <div type="button" class="btn btn-primary fileinput-button" id="upload-file">
            <span class="glyphicon glyphicon-upload"></span>上传文件&hellip;
            <input id="fileupload" type="file" name="files[]" multiple>
        </div>
        <button type="button" class="btn btn-success" id="create-folder">
            <span class="glyphicon glyphicon-folder-close"></span> 新建文件夹&hellip;
        </button>
        <button type="button" class="btn btn-default" id="reload">
            <span class="glyphicon glyphicon-refresh"></span> 刷新
        </button>
    </div>

    <div class="panel panel-default uploading">
        <div class="panel-heading">File Uploads in Progress</div>
        <table class="table table-striped"><tbody id="uploads"></tbody></table>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <ol class="breadcrumb" id="path"></ol>
        </div>
        <table class="table table-striped"><tbody id="listing"></tbody></table>
    </div>

    <p class="footer">© 2016 <a href="http://devcp.org/" target="_blank">devcp</a>
        v1.2.8</p>
</div>

<div class="modal fade" id="create-modal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create Folder</h4>
            </div>
            <div class="modal-body">
                <p>Please enter the name of the folder to be created:</p>
                <form onsubmit="return false">
                    <input type="text" autocomplete="off" id="create-input">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" id="create-confirm">Create Folder</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="move-modal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Move Item</h4>
            </div>
            <div class="modal-body">
                <p>Please enter the new location for this item:</p>
                <form onsubmit="return false">
                    <input type="text" autocomplete="off" id="move-input">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" id="move-confirm">Move Item</button>
            </div>
        </div>
    </div>
</div>

<script type="text/x-tmpl" id="template-listing">
      <tr class="row-file">
        <td class="column-icon">
          {% if (o.size != null) { %}
            <button type="button" class="btn btn-default btn-xs button-download">
              <span class="glyphicon glyphicon-download-alt"></span>
            </button>
          {% } else { %}
            <button type="button" class="btn btn-default btn-xs button-open">
              <span class="glyphicon glyphicon-folder-open"></span>
            </button>
          {% } %}
        </td>
        <td class="column-name"><p class="edit">{%=o.name%}</p></td>
        <td class="column-size">
          {% if (o.size != null) { %}
            <p>{%=formatFileSize(o.size)%}</p>
          {% } %}
        </td>
        <td class="column-date">
          {% if (o.date != null) { %}<p>{%=o.date%}</p>{% } %}
        </td>
        <!--
        <td class="column-move">
          <button type="button" class="btn btn-default btn-xs button-move">
          <span class="glyphicon glyphicon glyphicon-share-alt"></span>
          </button>
        </td>
          -->
        <td class="column-move">
          {% if (o.size != null) { %}
          <button type="button" class="btn btn-success btn-xs button-popover"
              data-container="body" data-toggle="popover" data-placement="bottom"
              data-content="111" title="地址">获取地址
           </button>
          {% } %}
        </td>
        <td class="column-move">
          {% if (o.size != null) { %}
          <button type="button" class="btn btn-info btn-xs button-view">
            <span class="glyphicon glyphicon-search"><!--查看--></span>
          </button>
          {% } %}
        </td>
        <td class="column-delete">
          <button type="button" class="btn btn-danger btn-xs button-delete">
            <span class="glyphicon glyphicon-trash"><!--删除--></span>
          </button>
        </td>
      </tr>
    </script>

<script type="text/x-tmpl" id="template-uploads">
      <tr class="row-file">
        <td class="column-icon">
          <button type="button" class="btn btn-warning btn-xs button-cancel">
            <span class="glyphicon glyphicon-ban-circle"></span>
          </button>
        </td>
        <td class="column-path"><p>{%=o.path%}</p></td>
        <td class="column-progress">
          <div class="progress">
            <div class="progress-bar" id="progress-bar"></div>
          </div>
        </ts>
      </tr>
    </script>

<script type="text/x-tmpl" id="template-alert">
      <div class="alert alert-{%=o.level%} alert-dismissable">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong>{%=o.title%}</strong>{%=o.description%}
      </div>
    </script>
</body>
</html>
