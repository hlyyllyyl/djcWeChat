<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="boxed">

    <!--CONTENT CONTAINER-->
    <!--===================================================-->
    <div id="content-container">

        <!--Page content-->
        <!--===================================================-->
        <div id="page-content">

             <div class="panel">
                  <div class="panel-heading">
                      <h3 class="panel-title">WYSIWYG Summernote Editor</h3>
                  </div>
                  <div class="panel-body">
                      <!--Summernote-->
                      <!--===================================================-->
                      <div id="demo-summernote">
                          <h4><span style="color: rgb(206, 198, 206); font-family: inherit; line-height: 1.1;">Please, write text here!</span><br></h4><h4><font color="#9c9c94"></font></h4>
                      </div>
                      <!--===================================================-->
                      <!-- End Summernote -->
                  </div>
              </div>
        </div>
        <!--===================================================-->
        <!--End page content-->

    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {

        // SUMMERNOTE
        // =================================================================
        // Require Summernote
        // http://hackerwins.github.io/summernote/
        // =================================================================
        $('#demo-summernote, #demo-summernote-full-width').summernote({
            height : '230px'
        });
        // SUMMERNOTE AIR-MODE
        // =================================================================
        // Require Summernote
        // http://hackerwins.github.io/summernote/
        // =================================================================
        $('#demo-summernote-airmode').summernote({
            airMode: true
        });





        // SUMMERNOTE CLICK TO EDIT
        // =================================================================
        // Require Summernote
        // http://hackerwins.github.io/summernote/
        // =================================================================
        $('#demo-edit-text').on('click', function(){
            $('#demo-summernote-edit').summernote({focus: true});
        });


        $('#demo-save-text').on('click', function(){
            $('#demo-summernote-edit').summernote('destroy');
        });

    })

</script>
