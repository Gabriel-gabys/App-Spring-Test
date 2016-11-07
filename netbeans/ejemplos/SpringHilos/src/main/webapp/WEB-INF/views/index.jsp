<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>jQuery UI Progressbar - Custom Label</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <style>
            .ui-progressbar {
                position: relative;
            }
            .progress-label {
                position: absolute;
                left: 50%;
                top: 4px;
                font-weight: bold;
                text-shadow: 1px 1px 0 #fff;
            }
        </style>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                var objInterval = {
                    url: 'http://localhost:8083/SpringHilos/aplication/response2',
                    progressbar: {
                        bar: {
                            id: '#progressbar',
                            item: null
                        },
                        label: {
                            id: '.progress-label',
                            item: null
                        }
                    },
                    percentageTotal: 100,
                    timeLoop: 1500,
                    interval: null,
                    messages: {
                        ajaxError: 'Disculpe, existió un problema',
                        labelValue: 'value',
                        labelComplete: 'Complete'
                    },
                    instanceProgress: function () {
                        objInterval.progressbar.bar.item = $(objInterval.progressbar.bar.id);
                        objInterval.progressbar.label.item = $(objInterval.progressbar.label.id);
                        
                        objInterval.progressbar.bar.item.progressbar({
                            value: false,
                            change: function () {
                                objInterval.progressbar.label.item.text(objInterval.progressbar.bar.item.progressbar(objInterval.messages.labelValue) + '%');
                            },
                            complete: function () {
                                objInterval.progressbar.label.item.text(objInterval.messages.labelComplete);
                            }
                        });
                    },
                    callnterval: function () {
                        objInterval.instanceProgress();
                        
                        objInterval.interval = setInterval(
                                objInterval.call, objInterval.timeLoop);
                    },
                    callClearInterval: function () {
                        clearInterval(objInterval.interval)
                    },
                    call: function() {
                        $.ajax({
                            url : objInterval.url,
                            type : 'GET',
                            dataType : 'json',
                            success : function(data) {
                                var percentage = objInterval.getProgress(data.index, data.totalRecords);
                                
                                console.log(data, percentage);
                                
                                objInterval.progressbar.bar.item.progressbar(objInterval.messages.labelValue, percentage);
                                
                                if (percentage >= objInterval.percentageTotal) {
                                    objInterval.callClearInterval();
                                }
                            },
                            error : function(xhr, status) {
                                console.log(objInterval.messages.ajaxError);
                                
                                objInterval.callClearInterval();
                            }
                        });
                    },
                    getProgress: function (index, total) {
                        var progress = objInterval.percentageTotal / total;
                        
                        return index * progress;
                    }
                };
                
                //objInterval.callnterval();
                
                $('#progressbar').progress({
                    url: 'http://localhost:8083/SpringHilos/aplication/response2',
                    pLabel: '.progress-label'
                });
            });
            
            (function($) {
                $.fn.extend({
                    progress: function (options) {
                        var defaultOptions = {
                            url: '',
                            pLabel: '',
                            timeLoop: 1500,
                            messages: {
                                ajaxError: 'Disculpe, existió un problema',
                                labelValue: 'value',
                                labelComplete: 'Complete'
                            },
                            callback: function (data) {
                                
                                var percentageProgress = getProgress(data.index, data.totalRecords);

                                console.log(data, percentageProgress);

                                contentProgressBar.progressbar(defaultOptions.messages.labelValue, percentageProgress);

                                if (percentageProgress >= percentage) {
                                    loop.callClearInterval();
                                }
                                
                                if (data.procesando === false) {
                                    loop.callClearInterval();
                                }
                            }
                        };
                        
                        $.extend(defaultOptions, options);
                        
                        var loop = {
                            interval: null,
                            callnterval: function (callback) {
                                if (callback !== null) {
                                    loop.interval = setInterval(callback, defaultOptions.timeLoop);
                                } else {
                                    console.log('No hay función callback a ejecutar en el loop ...');
                                }
                            },
                            callClearInterval: function () {
                                clearInterval(loop.interval)
                            }
                        };
                        var contentProgressBar = $(this);
                        var labelProgressBar = $(this).find(defaultOptions.pLabel);
                        var percentage = 100;
                        
                        function instanceProgress () {
                            contentProgressBar.progressbar({
                                value: false,
                                change: function () {
                                    labelProgressBar.text(contentProgressBar.progressbar(defaultOptions.messages.labelValue) + '%');
                                },
                                complete: function () {
                                    labelProgressBar.text(defaultOptions.messages.labelComplete);
                                }
                            });
                        }
                        
                        function call () {
                            $.ajax({
                                url : defaultOptions.url,
                                type : 'GET',
                                dataType : 'json',
                                success : defaultOptions.callback,
                                error : function(xhr, status) {
                                    console.log(defaultOptions.messages.ajaxError);

                                    loop.callClearInterval();
                                }
                            });
                        }
                        
                        function getProgress (index, total) {
                            var progress = percentage / total;
                            
                            progress = ((total === 0) ? total : progress);

                            return index * progress;
                        }
                        
                        instanceProgress();
                        
                        loop.callnterval(call);
                    }
                });
            })(jQuery);
        </script>
    </head>
    <body>

        <div id="progressbar"><div class="progress-label">Loading...</div></div>


    </body>
</html>