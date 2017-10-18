<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <title>秒杀详情页</title>
        <%@include file="common/head.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="panel panen-default text-center">
                <div class="panel-heading">
                    <h1>${seckill.name}</h1>
                </div>
            </div>
            <div class="panel-body">
                <h2 class="text-danger text-center">
                    <span class="glyphicon glyphicon-time"></span>
                    <span class="glyphicon" id="seckill-box"></span>
                </h2>
            </div>
        </div>

        <!-- 登录弹出层，输入电话 -->
        <div id="killPhoneModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title text-center">
                            <span class="glyphicon glyphicon-phone"></span>秒杀电话:
                        </h3>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-8 col-xs-offset-2">
                                <input type="text" name="killPhone" id="killPhoneKey" class="form-control"
                                    placeholder="请输入手机号"/>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <!-- 验证信息 -->
                        <span id="killPhoneMessage" class="glyphicon"></span>
                        <button type="button" id="killPhoneBtn" class="btn btn-success">
                            <span class="glyphicon glyphicon-phone"></span>Submit
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="https://cdn.bootcss.com/jquery.countdown/2.2.0/jquery.countdown.min.js"></script>
    <script type="text/javascript" src="/resources/script/seckill.js"></script>
    <script type="text/javascript">
        
        $(function () {

            // 使用EL表达式传入参数
            seckill.detail.init({
                seckillId: ${seckill.seckillId},
                startTime: ${seckill.startTime.time},
                endTime: ${seckill.endTime.time}
            });

        });
        
    </script>
</html>