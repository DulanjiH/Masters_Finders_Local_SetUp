$(document).ready(function () {

    loadUniversity();
    loadAllUniDetails();

    registerShow();
    signupShow();
    loginShow();
    hidePopup();



});

function registerShow() {
    $('.register-nav').on('click', function (evt) {
        $('.registration-pop-up-wrp, .sign-up-pop-up-wrp, .log-in-pop-up-wrp, .pop-up-overlay').removeClass('show');
        evt.preventDefault();

        $('.registration-pop-up-wrp, .pop-up-overlay').toggleClass('show');
    });
}

function signupShow() {
    $('.signup-nav').on('click', function (evt) {
        $('.registration-pop-up-wrp, .sign-up-pop-up-wrp, .log-in-pop-up-wrp, .pop-up-overlay').removeClass('show');
        evt.preventDefault();

        $('.sign-up-pop-up-wrp, .pop-up-overlay').toggleClass('show');


    });
}

function loginShow() {
    $('.login-nav').on('click', function (evt) {
        $('.registration-pop-up-wrp, .sign-up-pop-up-wrp, .log-in-pop-up-wrp, .pop-up-overlay').removeClass('show');
        evt.preventDefault();

        $('.log-in-pop-up-wrp, .pop-up-overlay').toggleClass('show');

    });
}

function hidePopup() {
    $('button.cancelbtn, .pop-up-overlay').on('click', function (evt) {
        evt.preventDefault();

        $('.registration-pop-up-wrp, .sign-up-pop-up-wrp, .log-in-pop-up-wrp, .pop-up-overlay').removeClass('show');
    })
}

function loadPrograme() {

    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {

            var listhtml = `<option value="">Select Programe</option>`;
            var jo = JSON.parse(request.responseText);

            if (jo.status == "Ok") {

                for (var prog of jo.data) {
                    listhtml += `<option value="` + prog.prname + ` "  >` + prog.prname + `</option>`;
                }
            } else {
                alert(jo.data);
            }
            document.getElementById("programme").innerHTML = listhtml;
        }
    };
    var un = document.getElementById("university").value;
    request.open("GET", "LoadDetails?type=programe&un=" + un, true);
    request.send();
}

function loadUniversity() {

    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var listhtml = `<option value="">Sellect University</option>`;
            var jo = JSON.parse(request.responseText);

            if (jo.status == "Ok") {
                for (var uni of jo.data) {
                    listhtml += `<option value="` + uni.unid + ` "  >` + uni.uniname + `</option>`;
                }
                loadPrograme();
            } else {
                alert(jo.data);
            }
            document.getElementById("university").innerHTML = listhtml;
            document.getElementById("universitycd").innerHTML = listhtml;
        }
    };

    request.open("GET", "LoadDetails?type=university", true);
    request.send();
}

function loadFaculty() {

    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {

            var listhtml = `<option value="">Select Faculty</option>`;
            var jo = JSON.parse(request.responseText);

            if (jo.status == "Ok") {
                for (var fac of jo.data) {
                    listhtml += `<option value="` + fac.facid + ` "  >` + fac.facname + `</option>`;
                }
            } else {
                alert(jo.data);
            }
            document.getElementById("faculty").innerHTML = listhtml;
        }
    };
    var universiry = document.getElementById("universitycd").value;
    request.open("GET", "LoadDetails?type=faculty&universirycd=" + universiry, true);
    request.send();
}

//function loadAllUniDetails() {
//
//    var request = new XMLHttpRequest();
//    request.onreadystatechange = function () {
//
//        if (request.readyState === 4 && request.status === 200) {
//            var listhtml = "";
//            var jo = JSON.parse(request.responseText);
//
//            if (jo.status == "Ok") {
//                for (var item of jo.data) {
//                    listhtml += `<div class="card-item">
//                      <div class="card-item-inner-wrp">
//                                        <div class="course-name">
//                                            ` + item.name + `
//                                        </div>
//                                        <div class="course-description">
//                                            ` + item.des + `
//                                        </div>
//
//                                        <div class="course-detail-outer-wrp">
//                                            <div class="course-detail">
//                                                <div class="payment-block">
//                                                    Payment : <span class="payment">  ` + item.pay + `</span>
//                                                </div>
//                                                <div class="university-block">
//                                                    University : <span class="university">` + item.uni + `</span>
//                                                </div>
//                                                <div class="location-block">
//                                                    University World Rank : <span class="location">` + item.loc + `</span>
//                                                </div>
//                                            </div>
//                                            <div class="btn-wrp">
//                                                <a href="` + item.link + `" class="btn btn-secondary">More Details</a>
//                                            </div>
//                                        </div>
//                                    </div>
//                                </div>`
//                }
//            } else {
//                alert(jo.data);
//            }
//            document.getElementById("coursecard").innerHTML = listhtml;
//        }
//    };
//    var parameter= "university=" + document.getElementById("university").value;
//     parameter += "&programme ="+document.getElementById("programme").value;
//    request.open("GET", "SearchCourceDetails?parameter=" +parameter, true);
//    request.send();
//}


document.getElementById("SignIn").addEventListener("click", function () {

    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            alert("fdfduffudf");
            if (request.responseText === "Succsess") {
                alert("fdfduffudf");
                window.location.reload();
            } else {
                alert(request.responseText);
            }
        }
    };

    var parameter = "email=" + document.getElementById("signIn_email").value;
    parameter += "&password=" + document.getElementById("signIn_password").value;

    request.open("POST", "SignIn", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    request.send(parameter);
});


document.getElementById("SignOut").addEventListener("click", function () {

    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            window.location.reload();
        }
    };

    request.open("GET", "SignUp", true);
    request.send();
});

//
//  document.getElementById("SignUp").addEventListener("click", function () {
//        var request = new XMLHttpRequest();
//        
//                request.onreadystatechange = function () {                
//                     alert("AAA");
//                    if (request.readyState === 4 && request.status === 200) {
//                    alert("BB");
//                if (request.responseText === "Succsess") {
//                    alert("Your Sign Up Processe is Done ");
//                } else {
//                    alert(request.responseText);
//                }
//            }
//        };
//        var parmeter = "email=" + document.getElementById("Singup_email").value;
//        parmeter += "&uname=" + document.getElementById("Singup_uname").value;
//        parmeter += "&mobile=" + document.getElementById("Singup_mobile").value;
//        parmeter += "&password=" + document.getElementById("Singup_psword").value;
//        
//        request.open("POST", "SignUp", true);
//        request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//        request.send(parmeter);
//
//    });

//document.getElementById("cousreRegistration").addEventListener("click", function () {
//    alert("course-registrations");
//    var request = new XMLHttpRequest();
//    request.onreadystatechange = function () {
//        alert("bbb");
//        if (request.readyState === 4 && request.status === 200) {
//            alert("sss");
//            if (request.responseText === "Succsess") {
//                alert("Course Registration is Succufull");
//                window.location.reload();
//            } else {
//                alert(request.responseText);
//            }
//        }
//    };
//    var parameter = "cname=" + document.getElementById("cr_cname").value;
//    parameter += "&description=" + document.getElementById("cr_description").value;
//    parameter += "&payment=" + document.getElementById("cr_payment").value;
//    parameter += "&url=" + document.getElementById("cr_url").value;
//    parameter += "&facid=" + document.getElementById("faculty").value;
//
//    alert(parameter);
//    request.open("POST", "SaveCourceDetails", true);
//    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//    request.send(parameter);
//
//});