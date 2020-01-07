function  showError(mssage) {
    swal(
        {
            title: mssage,
            type: "error",
            confirmButtonText: "#springMessage('common.confirm')"
        }
    );
}
function  showSuccess(mssage) {
    swal(
        {
            title: mssage,
            type: "success",
            confirmButtonText: "#springMessage('common.confirm')"
        }
    );
}
function  showError() {
    swal(
        {
            title: "#springMessage('common.operate.fail')" ,
            type: "error",
            confirmButtonText: "#springMessage('common.confirm')"
        }
    );
}

function  showSuccess() {
    swal(
        {
            title: "#springMessage('common.operate.successful')" ,
            type: "success",
            confirmButtonText: "#springMessage('common.confirm')"
        }
    );
}

function  showConfirm(id){

    swal({
            title: "#springMessage('common.system.info.alert.dlg')",
            type: "warning",
            showCancelButton: true,
            // closeOnConfirm: true,
            confirmButtonText: "#springMessage('common.confirm')",
            cancelButtonText: "#springMessage('common.cancel')"
        },
        function (isConfirm) {
            if(isConfirm){
                doConfirm(id);
            }
        })
}

function  showMethodConfirm(doConfirm,ids){

    swal({
            title: "#springMessage('common.system.info.alert.dlg')",
            type: "warning",
            showCancelButton: true,
            // closeOnConfirm: true,
            confirmButtonText: "#springMessage('common.confirm')",
            cancelButtonText: "#springMessage('common.cancel')"
        },
        function (isConfirm) {
            if(isConfirm){
                doConfirm(ids);
            }
        })
}