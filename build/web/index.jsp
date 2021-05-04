<%-- 
    Document   : index
    Created on : Mar 16, 2021, 2:50:28 PM
    Author     : Dulanji
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="indexpg" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Master's Finder - your masters at your finger tips</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/one-page-wonder.min.css" rel="stylesheet">

        <script src="https://kit.fontawesome.com/4a9be88ad8.js" crossorigin="anonymous"></script>

    </head>

    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#" title="Master's Finder">
                    <i class="fas fa-graduation-cap"></i>
                    <span class="name">Master's Finders</span>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <indexpg:choose>
                            <indexpg:when test="${sessionScope.u != null}">
                                <li class="nav-item">
                                    <a href="#" class="nav-link sign-out" id="SignOut">Sing Out</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link register-nav" href="#">Registration</a>
                                </li>
                            </indexpg:when>
                            <indexpg:otherwise>
                                <li class="nav-item">
                                    <a class="nav-link signup-nav" href="#">Sign Up</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link login-nav" href="#">Sign In</a>
                                </li>
                            </indexpg:otherwise>
                        </indexpg:choose>

                    </ul>
                    <div class="logged-user">
                        <indexpg:if test="${sessionScope.u != null}">
                            <span class="name">${sessionScope.u.name}</span>
                        </indexpg:if>
                    </div>

                </div>
            </div>
        </nav>

        <header class="masthead text-center text-white">
            <div class="masthead-content">
                <div class="container">
                    <h1 class="masthead-heading mb-0">Choose your University,</h1>
                    <h2 class="masthead-subheading mb-0">Choose your Masters</h2>
                    <a href="#" class="btn btn-secondary btn-xl rounded-pill mt-5">Learn More</a>
                </div>
            </div>
            <!-- <div class="bg-circle-1 bg-circle"></div>
            <div class="bg-circle-2 bg-circle"></div>
            <div class="bg-circle-3 bg-circle"></div>
            <div class="bg-circle-4 bg-circle"></div> -->
        </header>

        <section>
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 order-lg-2">
                        <div class="p-5">
                            <img class="img-fluid rounded-circle" src="img/may-masters-degree.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6 order-lg-1">
                        <div class="p-5">
                            <h2 class="display-4">About Master's Finder</h2>
                            <p>Masters Finder  facilitates easy searching and viewing of basic details of Masters Degree Programs in Government Universities. It is a web based solution to cater for easily selecting a suitable Master’s Degree Program from the available Programs with filtering.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section class="filteration">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-12">
                        <div class="p-5">
                            <h2 class="display-4">Select your masters</h2>
                            <div class="filteration-wrp">
                                <span>Filtered by</span>
                                <div class="filter-selectors">

                                    <div class="university-selector">
                                        <select name="university" id="university" onchange="loadAllUniDetails();loadPrograme();loadAllUniDetails();" ></select>
                                    </div>

                                    <div class="programme-selector">
                                        <select name="programme" id="programme" onchange="loadAllUniDetails()"> </select>
                                    </div>

                                </div>
                            </div>
                            <div class="card-wrp" id="coursecard">   

                            </div>
                            </section>

                            <!-- <section>
                              <div class="container">
                                <div class="row align-items-center">
                                  <div class="col-lg-6 order-lg-2">
                                    <div class="p-5">
                                      <img class="img-fluid rounded-circle" src="img/03.jpg" alt="">
                                    </div>
                                  </div>
                                  <div class="col-lg-6 order-lg-1">
                                    <div class="p-5">
                                      <h2 class="display-4">Let there be rock!</h2>
                                      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod aliquid, mollitia odio veniam sit iste esse assumenda amet aperiam exercitationem, ea animi blanditiis recusandae! Ratione voluptatum molestiae adipisci, beatae obcaecati.</p>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </section> -->

                            <!-- Footer -->
                            <footer class="py-4 bg-grey">
                                <div class="container">
                                    <div class="footer-detail-wrp">
                                        <div class="row">
                                            <div class="col-12 col-md-4">
                                                <div class="footer-logo">
                                                    <a href="/" title="Master's Finder"><i class="fas fa-graduation-cap"></i></a>
                                                </div>
                                            </div>
                                            <div class="col-12 col-md-4">
                                                <div class="contact-details">
                                                    <div class="address">
                                                        <span class="icon"><i class="fas fa-map-marker-alt"></i></span>
                                                        Cecilia Chapman
                                                        711-2880 Nulla St.
                                                        Mankato Mississippi 96522
                                                        (257) 563-7401
                                                    </div>
                                                    <div class="email">
                                                        <span class="icon"><i class="fas fa-envelope"></i></span>
                                                        <a href="mailto:mastersFinder@support.com" title="mastersFinder@support.com">mastersFinder@support.com</a>
                                                    </div>
                                                    <div class="tel">
                                                        <span class="icon"><i class="fas fa-phone-alt"></i></span>
                                                        <a href="tel:0123456789" title="0123456789">0123456789</a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-12 col-md-4">
                                                <div class="social-media">
                                                    <ul>
                                                        <li class="facebook"><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                                                        <li class="linkedin"><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                                                        <li class="twitter"><a href="#"><i class="fab fa-twitter"></i></a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="container">
                                    <p class="m-0 text-center small copyright">Copyright &copy; Master's Finder 2021</p>
                                </div>
                                <!-- /.container -->
                            </footer>

                            <div class="pop-up-overlay"></div>

                            <!-- login popup start -->
                            <div class="log-in-pop-up-wrp">
                                <div class="pop-up-content animate">
                                    <div class="login-introduction">
                                        <div class="container">
                                            <h3>Login on Master's Finder</h3>
                                        </div>
                                    </div>
                                    <div class="form-content">
                                        <form method="post">
                                            <div class="container">
                                                <div class="form-row">
                                                    <label for="uname"><b>Username</b></label>
                                                    <input type="text" placeholder="Enter Username" name="uname" id="signIn_email" required class="form-control form-control-solid">
                                                </div>

                                                <div class="form-row">
                                                    <label for="psw"><b>Password</b></label>
                                                    <input type="password" placeholder="Enter Password" name="psw" id="signIn_password" required class="form-control form-control-solid">

                                                </div>

                                                <div class="login-button-wrp">
                                                    <label>
                                                        <input type="checkbox" checked="checked" name="remember"> Remember me
                                                    </label>
                                                    <button class="login-button btn-secondary" type="submit" id="SignIn">Sign In</button>
                                                </div>
                                            </div>

                                            <div class="container">
                                                <div class="close-pop-up">
                                                    <button type="button" class="cancelbtn">Cancel</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <!-- login pop up end -->


                            <!-- sign up popup start -->
                            <div class="sign-up-pop-up-wrp">
                                <div class="pop-up-content animate">
                                    <div class="login-introduction">
                                        <div class="container">
                                            <h3>Sign up on Master's Finder</h3>
                                        </div>
                                    </div>
                                    <div class="form-content">
                                        <form method="post">
                                            <div class="container">
                                                <div class="form-row">
                                                    <div class="col-12 col-md-12">
                                                        <label for="fname"><b>First Name</b></label>
                                                        <input type="text" placeholder="First Name" name="fname" id="Singup_uname" required class="form-control form-control-solid">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="col-12 col-md-6">
                                                        <label for="email"><b>Email</b></label>
                                                        <input type="email" placeholder="Email" name="email" id="Singup_email" required class="form-control form-control-solid">
                                                    </div>

                                                    <div class="col-12 col-md-6">
                                                        <label for="telephone"><b>Phone Number</b></label>
                                                        <input type="tel" placeholder="Phone Number" name="telephone" id="Singup_mobile" required class="form-control form-control-solid">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <label for="pwd"><b>Password</b></label>
                                                    <input type="password" placeholder="Password" name="pwd" required class="form-control form-control-solid">
                                                </div>

                                                <div class="form-row">
                                                    <label for="cpwd"><b>Confirm Password</b></label>
                                                    <input type="password" placeholder="Confirm Password" name="cpwd" id="Singup_psword"  required class="form-control form-control-solid">
                                                </div>
                                            </div>

                                            <div class="container">
                                                <div class="close-pop-up">
                                                    <button type="button" class="cancelbtn">Cancel</button>
                                                    <button class="login-button btn-secondary" type="submit" id="SignUp">Save</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <!-- sign up popup start -->

                            <!-- registration popup start -->
                            <div class="registration-pop-up-wrp">
                                <div class="pop-up-content animate">
                                    <div class="login-introduction">
                                        <div class="container">
                                            <h3>Register on Master's Finder</h3>
                                        </div>
                                    </div>
                                    <div class="form-content">
                                        <form method="post">
                                            <div class="container">
                                                <div class="form-row">
                                                    <div class="col-12">
                                                        <label for="cname"><b>Course Name</b></label>
                                                        <input type="text" placeholder="Course Name" id="cr_cname" name="cname" required class="form-control form-control-solid">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="col-12">
                                                        <label for="cr_description"><b>Course Description</b></label>
                                                        <textarea name="cr_description" id="cr_description" placeholder="Course Description" required class="form-control form-control-solid"></textarea>
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="col-12 col-md-6">
                                                        <label for="university_name"><b>University Name</b></label>

                                                        <select name="university" id="universitycd" onchange="loadFaculty()" class="form-control form-control-solid" required></select>

                                                    </div>
                                                    <div class="col-12 col-md-6">
                                                        <label for="faculty"><b>Faculty</b></label>
                                                        <select name="faculty" id="faculty" class="form-control form-control-solid" required></select>
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <div class="col-12">
                                                        <label for="payment"><b>Payment</b></label>
                                                        <input type="text" placeholder="Payment" name="payment" id="cr_payment"  required class="form-control form-control-solid">
                                                    </div>
                                                </div>

                                                <div class="form-row">
                                                    <label for="more_info"><b>More Info URL</b></label>
                                                    <input type="text" placeholder="URL" name="more_info" id="cr_url" required class="form-control form-control-solid">
                                                </div>
                                            </div>

                                            <div class="container">
                                                <div class="close-pop-up">
                                                    <button type="button" class="cancelbtn">Cancel</button>
                                                    <button class="login-button btn-secondary" id="cousreRegistration" type="submit">Save</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <!-- registration popup end -->


                            <!-- Bootstrap core JavaScript -->
                            <script src="vendor/jquery/jquery.min.js"></script>
                            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

                            <!-- Custom jquery for this template -->
                            <script type="text/javascript" src="js/main.js"></script>

                            <script>

                                                            document.getElementById("SignUp").addEventListener("click", function () {
                                                                var request = new XMLHttpRequest();

                                                                request.onreadystatechange = function () {
                                                                   
                                                                    if (request.readyState === 4 && request.status === 200) {
                                                                      
                                                                        if (request.responseText === "Succsess") {
                                                                            alert("Your Sign Up Processe is Done ");
                                                                        } else {
                                                                            alert(request.responseText);
                                                                        }
                                                                    }
                                                                };
                                                                var parmeter = "uname=" + document.getElementById("Singup_uname").value;
                                                                parmeter += "&email=" + document.getElementById("Singup_email").value;
                                                                parmeter += "&mobile=" + document.getElementById("Singup_mobile").value;
                                                                parmeter += "&password=" + document.getElementById("Singup_psword").value;

                                                                request.open("POST", "SignUp", true);
                                                                request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                                                                request.send(parmeter);

                                                            });

                                                            document.getElementById("cousreRegistration").addEventListener("click", function () {
                                                              
                                                                var request = new XMLHttpRequest();
                                                                request.onreadystatechange = function () {
                                                                  
                                                                    if (request.readyState === 4 && request.status === 200) {
                                                                        
                                                                        if (request.responseText === "Succsess") {
                                                                            alert("Course Registration is Succufull");
                                                                            window.location.reload();
                                                                        } else {
                                                                            alert(request.responseText);
                                                                        }
                                                                    }
                                                                };
                                                                var parameter = "cname=" + document.getElementById("cr_cname").value;
                                                                parameter += "&description=" + document.getElementById("cr_description").value;
                                                                parameter += "&payment=" + document.getElementById("cr_payment").value;
                                                                parameter += "&url=" + document.getElementById("cr_url").value;
                                                                parameter += "&facid=" + document.getElementById("faculty").value;
                                                                parameter += "&unid=" + document.getElementById("universitycd").value;

                                                                alert(parameter);
                                                                request.open("POST", "SaveCourceDetails", true);
                                                                request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                                                                request.send(parameter);
                                                            });

                                                            document.getElementById("SignIn").addEventListener("click", function () {

                                                                var request = new XMLHttpRequest();
                                                                request.onreadystatechange = function () {

                                                                    if (request.readyState === 4 && request.status === 200) {
                                                                      
                                                                        if (request.responseText === "Succsess") {
                                                                            
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


                                                            function loadAllUniDetails() {

                                                                var request = new XMLHttpRequest();
                                                                request.onreadystatechange = function () {

                                                                    if (request.readyState === 4 && request.status === 200) {
                                                                        var listhtml = "";
                                                                        var jo = JSON.parse(request.responseText);

                                                                        if (jo.status == "Ok") {
                                                                            for (var item of jo.data) {
                                                                                listhtml += `<div class="card-item">
                      <div class="card-item-inner-wrp">
                                        <div class="course-name">
                                            ` + item.name + `
                                        </div>
                                        <div class="course-description">
                                            ` + item.des + `
                                        </div>

                                        <div class="course-detail-outer-wrp">
                                            <div class="course-detail">
                                                <div class="payment-block">
                                                    Payment : <span class="payment">  ` + item.pay + `</span>
                                                </div>
                                                <div class="university-block">
                                                    University : <span class="university">` + item.uni + `</span>
                                                </div>
                                                <div class="location-block">
                                                    University World Rank : <span class="location">` + item.loc + `</span>
                                                </div>
                                            </div>
                                            <div class="btn-wrp">
                                                <a href="` + item.link + `" class="btn btn-secondary">More Details</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>`
                                                                            }
                                                                        } else {
                                                                            alert(jo.data);
                                                                        }
                                                                        document.getElementById("coursecard").innerHTML = listhtml;
                                                                    }
                                                                };
                                                                var parameter = "university=" + document.getElementById("university").value;
                                                                parameter += "&programme=" + document.getElementById("programme").value;
                                                                parameter += "&university=" + document.getElementById("university").value;
                                                                request.open("GET", "SearchCourceDetails?parameter=" + parameter, true);
                                                                request.send();
                                                            }
                            </script>

                            </body>
                            </html>
