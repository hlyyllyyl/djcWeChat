<div class="boxed">

    <!--CONTENT CONTAINER-->
    <!--===================================================-->
    <div id="content-container">

        <!--Page Title-->
        <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
        <div id="page-title">
            <h1 class="page-header text-overflow">水电费</h1>

            <!--Searchbox-->
            <div class="searchbox">
                <div class="input-group custom-search-form">
                    <input type="text" class="form-control" placeholder="Search..">
                    <span class="input-group-btn">
                                <button class="text-muted" type="button"><i class="demo-pli-magnifi-glass"></i></button>
                            </span>
                </div>
            </div>
        </div>
        <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
        <!--End page title-->

        <!--Page content-->
        <!--===================================================-->
        <div id="page-content">

            <div class="row">
                <div class="col-lg-7">

                    <!--Network Line Chart-->
                    <!--===================================================-->
                    <div id="demo-panel-network" class="panel">
                        <div class="panel-heading">
                            <div class="panel-control">
                                <button id="demo-panel-network-refresh" data-toggle="panel-overlay" data-target="#demo-panel-network" class="btn"><i class="demo-pli-repeat-2 icon-lg"></i></button>
                                <div class="btn-group">
                                    <button class="dropdown-toggle btn" data-toggle="dropdown" aria-expanded="false"><i class="demo-pli-gear icon-lg"></i></button>
                                    <ul class="dropdown-menu dropdown-menu-right">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                    </ul>
                                </div>
                            </div>
                            <h3 class="panel-title">Network</h3>
                        </div>

                        <!--Morris line chart placeholder-->
                        <div id="morris-chart-network" class="morris-full-content"></div>

                        <!--Chart information-->
                        <div class="panel-body">
                            <div class="row pad-top">
                                <div class="col-lg-8">
                                    <div class="media">
                                        <div class="media-left">
                                            <div class="media">
                                                <p class="text-semibold text-main">Temperature</p>
                                                <div class="media-left pad-no">
					                                        <span class="text-2x text-semibold text-nowrap text-main">
					                                            <i class="demo-pli-temperature"></i> 43.7
					                                        </span>
                                                </div>
                                                <div class="media-body">
                                                    <p class="mar-no">°C</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="media-body pad-lft">
                                            <div class="pad-btm">
                                                <p class="text-semibold text-main mar-no">Today Tips</p>
                                                <small>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</small>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-4">
                                    <p class="text-semibold text-main">Bandwidth Usage</p>
                                    <ul class="list-unstyled">
                                        <li>
                                            <div class="media">
                                                <div class="media-left">
                                                    <span class="text-2x text-semibold text-main">75.9</span>
                                                </div>
                                                <div class="media-body">
                                                    <p class="mar-no">Mbps</p>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="clearfix">
                                                <p class="pull-left mar-no">Outcome</p>
                                                <p class="pull-right mar-no">75%</p>
                                            </div>
                                            <div class="progress progress-xs">
                                                <div class="progress-bar progress-bar-info" style="width: 75%;">
                                                    <span class="sr-only">75%</span>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>


                    </div>
                    <!--===================================================-->
                    <!--End network line chart-->

                </div>
                <div class="col-lg-5">
                    <div class="row">
                        <div class="col-sm-6 col-lg-6">

                            <!--Sparkline Area Chart-->
                            <div class="panel panel-success panel-colorful">
                                <div class="pad-all">
                                    <p class="text-lg text-semibold"><i class="demo-pli-data-storage icon-fw"></i> HDD Usage</p>
                                    <p class="mar-no">
                                        <span class="pull-right text-bold">132Gb</span>
                                        Free Space
                                    </p>
                                    <p class="mar-no">
                                        <span class="pull-right text-bold">1,45Gb</span>
                                        Used space
                                    </p>
                                </div>
                                <div class="pad-all text-center">
                                    <!--Placeholder-->
                                    <div id="demo-sparkline-area"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-lg-6">

                            <!--Sparkline Line Chart-->
                            <div class="panel panel-info panel-colorful">
                                <div class="pad-all">
                                    <p class="text-lg text-semibold"><i class="demo-pli-wallet-2 icon-fw"></i> Earning</p>
                                    <p class="mar-no">
                                        <span class="pull-right text-bold">$764</span>
                                        Today
                                    </p>
                                    <p class="mar-no">
                                        <span class="pull-right text-bold">$1,332</span>
                                        Last 7 Day
                                    </p>
                                </div>
                                <div class="pad-all text-center">

                                    <!--Placeholder-->
                                    <div id="demo-sparkline-line"></div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-lg-6">

                            <!--Sparkline bar chart -->
                            <div class="panel panel-purple panel-colorful">
                                <div class="pad-all">
                                    <p class="text-lg text-semibold"><i class="demo-pli-bag-coins icon-fw"></i> Sales</p>
                                    <p class="mar-no">
                                        <span class="pull-right text-bold">$764</span>
                                        Today
                                    </p>
                                    <p class="mar-no">
                                        <span class="pull-right text-bold">$1,332</span>
                                        Last 7 Day
                                    </p>
                                </div>
                                <div class="pad-all text-center">

                                    <!--Placeholder-->
                                    <div id="demo-sparkline-bar" class="box-inline"></div>

                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-lg-6">

                            <!--Sparkline pie chart -->
                            <div class="panel panel-warning panel-colorful">
                                <div class="pad-all">
                                    <p class="text-lg text-semibold"><i class="demo-pli-check icon-fw"></i> Task Progress</p>
                                    <p class="mar-no">
                                        <span class="pull-right text-bold">34</span>
                                        Completed
                                    </p>
                                    <p class="mar-no">
                                        <span class="pull-right text-bold">79</span>
                                        Total
                                    </p>
                                </div>
                                <div class="pad-all">
                                    <ul class="list-group list-unstyled">
                                        <li class="mar-btm">
                                            <span class="label label-warning pull-right">15%</span>
                                            <p>Progress</p>
                                            <div class="progress progress-md">
                                                <div style="width: 15%;" class="progress-bar progress-bar-light">
                                                    <span class="sr-only">15%</span>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-4">
                    <!--List Todo-->
                    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                    <div class="panel panel-trans">
                        <div class="panel-heading">
                            <h3 class="panel-title">To do list</h3>
                        </div>
                        <div class="pad-ver">
                            <ul class="list-group bg-trans list-todo mar-no">
                                <li class="list-group-item">
                                    <input id="demo-todolist-1" class="magic-checkbox" type="checkbox">
                                    <label for="demo-todolist-1"><span>Find an idea. <span class="label label-danger">Important</span></span></label>
                                </li>
                                <li class="list-group-item">
                                    <input id="demo-todolist-2" class="magic-checkbox" type="checkbox" checked>
                                    <label for="demo-todolist-2"><span>Do some work</span></label>
                                </li>
                                <li class="list-group-item">
                                    <input id="demo-todolist-3" class="magic-checkbox" type="checkbox">
                                    <label for="demo-todolist-3"><span>Read the book</span></label>
                                </li>
                                <li class="list-group-item">
                                    <input id="demo-todolist-4" class="magic-checkbox" type="checkbox">
                                    <label for="demo-todolist-4"><span>Upgrade server <span class="label label-warning">Warning</span></span></label>
                                </li>
                                <li class="list-group-item">
                                    <input id="demo-todolist-5" class="magic-checkbox" type="checkbox" checked>
                                    <label for="demo-todolist-5"><span>Redesign my logo <span class="label label-info">2 Mins</span></span></label>
                                </li>
                            </ul>
                        </div>
                        <div class="input-group pad-all">
                            <input type="text" class="form-control" placeholder="New task" autocomplete="off">
                            <span class="input-group-btn">
					                    <button type="button" class="btn btn-success"><i class="demo-pli-add"></i></button>
					                </span>
                        </div>
                    </div>
                    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                    <!--End todo list-->
                </div>
                <div class="col-lg-4">
                    <div class="panel panel-trans">
                        <div class="panel-heading">
                            <div class="panel-control">
                                <a title="" data-html="true" data-container="body" data-original-title="&lt;p class='h4 text-semibold'&gt;Information&lt;/p&gt;&lt;p style='width:150px'&gt;This is an information bubble to help the user.&lt;/p&gt;" href="#" class="demo-psi-information icon-lg icon-fw unselectable text-info add-tooltip"></a>
                            </div>
                            <h3 class="panel-title">Services</h3>
                        </div>
                        <div class="bord-btm">
                            <ul class="list-group bg-trans">
                                <li class="list-group-item">
                                    <div class="pull-right">
                                        <input id="demo-online-status-checkbox" class="toggle-switch" type="checkbox" checked>
                                        <label for="demo-online-status-checkbox"></label>
                                    </div>
                                    Online status
                                </li>
                                <li class="list-group-item">
                                    <div class="pull-right">
                                        <input id="demo-show-off-contact-checkbox" class="toggle-switch" type="checkbox" checked>
                                        <label for="demo-show-off-contact-checkbox"></label>
                                    </div>
                                    Show offline contact
                                </li>
                                <li class="list-group-item">
                                    <div class="pull-right">
                                        <input id="demo-show-device-checkbox" class="toggle-switch" type="checkbox">
                                        <label for="demo-show-device-checkbox"></label>
                                    </div>
                                    Show my device icon
                                </li>
                            </ul>
                        </div>
                        <div class="panel-body">
                            <div class="pad-btm">
                                <p class="text-semibold text-main">Upgrade Progress</p>
                                <div class="progress progress-sm">
                                    <div class="progress-bar progress-bar-purple" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100" style="width: 15%;" role="progressbar">
                                        <span class="sr-only">15%</span>
                                    </div>
                                </div>
                                <small>15% Completed</small>
                            </div>
                            <div class="pad-btm">
                                <p class="text-semibold text-main">Database</p>
                                <div class="progress progress-sm">
                                    <div class="progress-bar progress-bar-success" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%;" role="progressbar">
                                        <span class="sr-only">70%</span>
                                    </div>
                                </div>
                                <small>70% Completed</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class='col-lg-4'>
                    <div class="panel panel-trans">
                        <div class="pad-all">
                            <div class="media mar-btm">
                                <div class="media-left">
                                    <img src="/assets/picture/2.png" class="img-md img-circle" alt="Avatar">
                                </div>
                                <div class="media-body">
                                    <p class="text-lg text-main text-semibold mar-no">Ralph West</p>
                                    <p>Project manager</p>
                                </div>
                            </div>
                            <blockquote class="bq-sm bq-open bq-close">Lorem ipsum dolor sit amet, consecte tuer adipiscing elit, sed diam nonummy nibh euismod tincidunt.</blockquote>
                        </div>

                        <div class="bord-top">
                            <ul class="list-group bg-trans bord-no">
                                <li class="list-group-item list-item-sm">
                                    <div class="media-left">
                                        <i class="demo-psi-facebook icon-lg"></i>
                                    </div>
                                    <div class="media-body">
                                        <a href="#" class="btn-link text-semibold">Facebook</a>
                                    </div>
                                </li>
                                <li class="list-group-item list-item-sm">
                                    <div class="media-left">
                                        <i class="demo-psi-twitter icon-lg"></i>
                                    </div>
                                    <div class="media-body">
                                        <a href="#" class="btn-link text-semibold">@RalphWe</a>
                                        <br>
                                        Design my themes with <a href="#" class="btn-link text-bold">#Bootstrap</a> Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
                                    </div>
                                </li>
                                <li class="list-group-item list-item-sm">
                                    <div class="media-left">
                                        <i class="demo-psi-instagram icon-lg"></i>
                                    </div>
                                    <div class="media-body">
                                        <a href="#" class="btn-link text-semibold">Ralphz</a>
                                    </div>
                                </li>
                                <li class="list-group-item list-item-sm">
                                    <div class="media-body">

                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="panel">
                        <div class="panel-heading">
                            <h3 class="panel-title">Order Status</h3>
                        </div>

                        <!--Data Table-->
                        <!--===================================================-->
                        <div class="panel-body">
                            <div class="pad-btm form-inline">
                                <div class="row">
                                    <div class="col-sm-6 table-toolbar-left">
                                        <button class="btn btn-purple"><i class="demo-pli-add icon-fw"></i>Add</button>
                                        <button class="btn btn-default"><i class="demo-pli-printer"></i></button>
                                        <div class="btn-group">
                                            <button class="btn btn-default"><i class="demo-pli-information"></i></button>
                                            <button class="btn btn-default"><i class="demo-pli-recycling"></i></button>
                                        </div>
                                    </div>
                                    <div class="col-sm-6 table-toolbar-right">
                                        <div class="form-group">
                                            <input type="text" autocomplete="off" class="form-control" placeholder="Search" id="demo-input-search2">
                                        </div>
                                        <div class="btn-group">
                                            <button class="btn btn-default"><i class="demo-pli-download-from-cloud"></i></button>
                                            <div class="btn-group">
                                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                                    <i class="demo-pli-gear"></i>
                                                    <span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu dropdown-menu-right" role="menu">
                                                    <li><a href="#">Action</a></li>
                                                    <li><a href="#">Another action</a></li>
                                                    <li><a href="#">Something else here</a></li>
                                                    <li class="divider"></li>
                                                    <li><a href="#">Separated link</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>Invoice</th>
                                        <th>User</th>
                                        <th>Order date</th>
                                        <th>Amount</th>
                                        <th class="text-center">Status</th>
                                        <th class="text-center">Tracking Number</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><a href="#" class="btn-link"> Order #53431</a></td>
                                        <td>Steve N. Horton</td>
                                        <td><span class="text-muted"><i class="fa fa-clock-o"></i> Oct 22, 2014</span></td>
                                        <td>$45.00</td>
                                        <td class="text-center">
                                            <div class="label label-table label-success">Paid</div>
                                        </td>
                                        <td class="text-center">-</td>
                                    </tr>
                                    <tr>
                                        <td><a href="#" class="btn-link"> Order #53432</a></td>
                                        <td>Charles S Boyle</td>
                                        <td><span class="text-muted"><i class="fa fa-clock-o"></i> Oct 24, 2014</span></td>
                                        <td>$245.30</td>
                                        <td class="text-center">
                                            <div class="label label-table label-info">Shipped</div>
                                        </td>
                                        <td class="text-center"><i class="fa fa-plane"></i> CGX0089734531</td>
                                    </tr>
                                    <tr>
                                        <td><a href="#" class="btn-link"> Order #53433</a></td>
                                        <td>Lucy Doe</td>
                                        <td><span class="text-muted"><i class="fa fa-clock-o"></i> Oct 24, 2014</span></td>
                                        <td>$38.00</td>
                                        <td class="text-center">
                                            <div class="label label-table label-info">Shipped</div>
                                        </td>
                                        <td class="text-center"><i class="fa fa-plane"></i> CGX0089934571</td>
                                    </tr>
                                    <tr>
                                        <td><a href="#" class="btn-link"> Order #53434</a></td>
                                        <td>Teresa L. Doe</td>
                                        <td><span class="text-muted"><i class="fa fa-clock-o"></i> Oct 15, 2014</span></td>
                                        <td>$77.99</td>
                                        <td class="text-center">
                                            <div class="label label-table label-info">Shipped</div>
                                        </td>
                                        <td class="text-center"><i class="fa fa-plane"></i> CGX0089734574</td>
                                    </tr>
                                    <tr>
                                        <td><a href="#" class="btn-link"> Order #53435</a></td>
                                        <td>Teresa L. Doe</td>
                                        <td><span class="text-muted"><i class="fa fa-clock-o"></i> Oct 12, 2014</span></td>
                                        <td>$18.00</td>
                                        <td class="text-center">
                                            <div class="label label-table label-success">Paid</div>
                                        </td>
                                        <td class="text-center">-</td>
                                    </tr>
                                    <tr>
                                        <td><a href="#" class="btn-link">Order #53437</a></td>
                                        <td>Charles S Boyle</td>
                                        <td><span class="text-muted"><i class="fa fa-clock-o"></i> Oct 17, 2014</span></td>
                                        <td>$658.00</td>
                                        <td class="text-center">
                                            <div class="label label-table label-danger">Refunded</div>
                                        </td>
                                        <td class="text-center">-</td>
                                    </tr>
                                    <tr>
                                        <td><a href="#" class="btn-link">Order #536584</a></td>
                                        <td>Scott S. Calabrese</td>
                                        <td><span class="text-muted"><i class="fa fa-clock-o"></i> Oct 19, 2014</span></td>
                                        <td>$45.58</td>
                                        <td class="text-center">
                                            <div class="label label-table label-warning">Unpaid</div>
                                        </td>
                                        <td class="text-center">-</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <hr>
                            <div class="pull-right">
                                <ul class="pagination text-nowrap mar-no">
                                    <li class="page-pre disabled">
                                        <a href="#">&lt;</a>
                                    </li>
                                    <li class="page-number active">
                                        <span>1</span>
                                    </li>
                                    <li class="page-number">
                                        <a href="#">2</a>
                                    </li>
                                    <li class="page-number">
                                        <a href="#">3</a>
                                    </li>
                                    <li>
                                        <span>...</span>
                                    </li>
                                    <li class="page-number">
                                        <a href="#">9</a>
                                    </li>
                                    <li class="page-next">
                                        <a href="#">&gt;</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!--===================================================-->
                        <!--End Data Table-->

                    </div>
                </div>
            </div>



        </div>
        <!--===================================================-->
        <!--End page content-->


    </div>
    <!--===================================================-->
    <!--END CONTENT CONTAINER-->

    <!--ASIDE-->
    <!--===================================================-->
    <aside id="aside-container">
        <div id="aside">
            <div class="nano">
                <div class="nano-content">

                    <!--Nav tabs-->
                    <!--================================-->
                    <ul class="nav nav-tabs nav-justified">
                        <li class="active">
                            <a href="#demo-asd-tab-1" data-toggle="tab">
                                <i class="demo-pli-speech-bubble-7"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#demo-asd-tab-2" data-toggle="tab">
                                <i class="demo-pli-information icon-fw"></i> Report
                            </a>
                        </li>
                        <li>
                            <a href="#demo-asd-tab-3" data-toggle="tab">
                                <i class="demo-pli-wrench icon-fw"></i> Settings
                            </a>
                        </li>
                    </ul>
                    <!--================================-->
                    <!--End nav tabs-->



                    <!-- Tabs Content -->
                    <!--================================-->
                    <div class="tab-content">

                        <!--First tab (Contact list)-->
                        <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                        <div class="tab-pane fade in active" id="demo-asd-tab-1">
                            <p class="pad-hor mar-top text-semibold text-main">
                                <span class="pull-right badge badge-warning">3</span> Family
                            </p>

                            <!--Family-->
                            <div class="list-group bg-trans">
                                <a href="#" class="list-group-item">
                                    <div class="media-left pos-rel">
                                        <img class="img-circle img-xs" src="/assets/picture/2.png" alt="Profile Picture">
                                        <i class="badge badge-success badge-stat badge-icon pull-left"></i>
                                    </div>
                                    <div class="media-body">
                                        <p class="mar-no">Stephen Tran</p>
                                        <small class="text-muted">Availabe</small>
                                    </div>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="media-left pos-rel">
                                        <img class="img-circle img-xs" src="/assets/picture/7.png" alt="Profile Picture">
                                    </div>
                                    <div class="media-body">
                                        <p class="mar-no">Brittany Meyer</p>
                                        <small class="text-muted">I think so</small>
                                    </div>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="media-left pos-rel">
                                        <img class="img-circle img-xs" src="/assets/picture/1.png" alt="Profile Picture">
                                        <i class="badge badge-info badge-stat badge-icon pull-left"></i>
                                    </div>
                                    <div class="media-body">
                                        <p class="mar-no">Jack George</p>
                                        <small class="text-muted">Last Seen 2 hours ago</small>
                                    </div>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="media-left pos-rel">
                                        <img class="img-circle img-xs" src="/assets/picture/4.png" alt="Profile Picture">
                                    </div>
                                    <div class="media-body">
                                        <p class="mar-no">Donald Brown</p>
                                        <small class="text-muted">Lorem ipsum dolor sit amet.</small>
                                    </div>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="media-left pos-rel">
                                        <img class="img-circle img-xs" src="/assets/picture/8.png" alt="Profile Picture">
                                        <i class="badge badge-warning badge-stat badge-icon pull-left"></i>
                                    </div>
                                    <div class="media-body">
                                        <p class="mar-no">Betty Murphy</p>
                                        <small class="text-muted">Idle</small>
                                    </div>
                                </a>
                                <a href="#" class="list-group-item">
                                    <div class="media-left pos-rel">
                                        <img class="img-circle img-xs" src="/assets/picture/9.png" alt="Profile Picture">
                                        <i class="badge badge-danger badge-stat badge-icon pull-left"></i>
                                    </div>
                                    <div class="media-body">
                                        <p class="mar-no">Samantha Reid</p>
                                        <small class="text-muted">Offline</small>
                                    </div>
                                </a>
                            </div>

                            <hr>
                            <p class="pad-hor text-semibold text-main">
                                <span class="pull-right badge badge-success">Offline</span> Friends
                            </p>

                            <!--Works-->
                            <div class="list-group bg-trans">
                                <a href="#" class="list-group-item">
                                    <span class="badge badge-purple badge-icon badge-fw pull-left"></span> Joey K. Greyson
                                </a>
                                <a href="#" class="list-group-item">
                                    <span class="badge badge-info badge-icon badge-fw pull-left"></span> Andrea Branden
                                </a>
                                <a href="#" class="list-group-item">
                                    <span class="badge badge-success badge-icon badge-fw pull-left"></span> Johny Juan
                                </a>
                                <a href="#" class="list-group-item">
                                    <span class="badge badge-danger badge-icon badge-fw pull-left"></span> Susan Sun
                                </a>
                            </div>


                            <hr>
                            <p class="pad-hor mar-top text-semibold text-main">News</p>

                            <div class="pad-hor">
                                <p class="text-muted">Lorem ipsum dolor sit amet, consectetuer
                                    <a data-title="45%" class="add-tooltip text-semibold" href="#">adipiscing elit</a>, sed diam nonummy nibh. Lorem ipsum dolor sit amet.
                                </p>
                                <small class="text-muted"><em>Last Update : Des 12, 2014</em></small>
                            </div>


                        </div>
                        <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                        <!--End first tab (Contact list)-->


                        <!--Second tab (Custom layout)-->
                        <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                        <div class="tab-pane fade" id="demo-asd-tab-2">

                            <!--Monthly billing-->
                            <div class="pad-all">
                                <p class="text-semibold text-main">Billing &amp; reports</p>
                                <p class="text-muted">Get <strong>$5.00</strong> off your next bill by making sure your full payment reaches us before August 5, 2016.</p>
                            </div>
                            <hr class="new-section-xs">
                            <div class="pad-all">
                                <span class="text-semibold text-main">Amount Due On</span>
                                <p class="text-muted text-sm">August 17, 2016</p>
                                <p class="text-2x text-thin text-main">$83.09</p>
                                <button class="btn btn-block btn-success mar-top">Pay Now</button>
                            </div>


                            <hr>

                            <p class="pad-hor text-semibold text-main">Additional Actions</p>

                            <!--Simple Menu-->
                            <div class="list-group bg-trans">
                                <a href="#" class="list-group-item"><i class="demo-pli-information icon-lg icon-fw"></i> Service Information</a>
                                <a href="#" class="list-group-item"><i class="demo-pli-mine icon-lg icon-fw"></i> Usage Profile</a>
                                <a href="#" class="list-group-item"><span class="label label-info pull-right">New</span><i class="demo-pli-credit-card-2 icon-lg icon-fw"></i> Payment Options</a>
                                <a href="#" class="list-group-item"><i class="demo-pli-support icon-lg icon-fw"></i> Message Center</a>
                            </div>


                            <hr>

                            <div class="text-center">
                                <div><i class="demo-pli-old-telephone icon-3x"></i></div>
                                Questions?
                                <p class="text-lg text-semibold text-main"> (415) 234-53454 </p>
                                <small><em>We are here 24/7</em></small>
                            </div>
                        </div>
                        <!--End second tab (Custom layout)-->
                        <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->


                        <!--Third tab (Settings)-->
                        <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                        <div class="tab-pane fade" id="demo-asd-tab-3">
                            <ul class="list-group bg-trans">
                                <li class="pad-top list-header">
                                    <p class="text-semibold text-main mar-no">Account Settings</p>
                                </li>
                                <li class="list-group-item">
                                    <div class="pull-right">
                                        <input class="toggle-switch" id="demo-switch-1" type="checkbox" checked>
                                        <label for="demo-switch-1"></label>
                                    </div>
                                    <p class="mar-no">Show my personal status</p>
                                    <small class="text-muted">Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</small>
                                </li>
                                <li class="list-group-item">
                                    <div class="pull-right">
                                        <input class="toggle-switch" id="demo-switch-2" type="checkbox" checked>
                                        <label for="demo-switch-2"></label>
                                    </div>
                                    <p class="mar-no">Show offline contact</p>
                                    <small class="text-muted">Aenean commodo ligula eget dolor. Aenean massa.</small>
                                </li>
                                <li class="list-group-item">
                                    <div class="pull-right">
                                        <input class="toggle-switch" id="demo-switch-3" type="checkbox">
                                        <label for="demo-switch-3"></label>
                                    </div>
                                    <p class="mar-no">Invisible mode </p>
                                    <small class="text-muted">Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. </small>
                                </li>
                            </ul>


                            <hr>

                            <ul class="list-group pad-btm bg-trans">
                                <li class="list-header"><p class="text-semibold text-main mar-no">Public Settings</p></li>
                                <li class="list-group-item">
                                    <div class="pull-right">
                                        <input class="toggle-switch" id="demo-switch-4" type="checkbox" checked>
                                        <label for="demo-switch-4"></label>
                                    </div>
                                    Online status
                                </li>
                                <li class="list-group-item">
                                    <div class="pull-right">
                                        <input class="toggle-switch" id="demo-switch-5" type="checkbox" checked>
                                        <label for="demo-switch-5"></label>
                                    </div>
                                    Show offline contact
                                </li>
                                <li class="list-group-item">
                                    <div class="pull-right">
                                        <input class="toggle-switch" id="demo-switch-6" type="checkbox" checked>
                                        <label for="demo-switch-6"></label>
                                    </div>
                                    Show my device icon
                                </li>
                            </ul>



                            <hr>

                            <p class="pad-hor text-semibold text-main mar-no">Task Progress</p>
                            <div class="pad-all">
                                <p>Upgrade Progress</p>
                                <div class="progress progress-sm">
                                    <div class="progress-bar progress-bar-success" style="width: 15%;"><span class="sr-only">15%</span></div>
                                </div>
                                <small class="text-muted">15% Completed</small>
                            </div>
                            <div class="pad-hor">
                                <p>Database</p>
                                <div class="progress progress-sm">
                                    <div class="progress-bar progress-bar-danger" style="width: 75%;"><span class="sr-only">75%</span></div>
                                </div>
                                <small class="text-muted">17/23 Database</small>
                            </div>

                        </div>
                        <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                        <!--Third tab (Settings)-->

                    </div>
                </div>
            </div>
        </div>
    </aside>
    <!--===================================================-->
    <!--END ASIDE-->

</div>