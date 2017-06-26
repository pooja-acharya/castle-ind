$(document).ready(function(){
     $(window).scroll(function () {
            if ($(this).scrollTop() > 50) {
                $('#back-to-top').fadeIn();
            } else {
                $('#back-to-top').fadeOut();
            }
        });
        // scroll body to 0px on click
        $('#back-to-top').click(function () {
            $('#back-to-top').tooltip('hide');
            $('body,html').animate({
                scrollTop: 0
            }, 800);
            return false;
        });
        
        $('#back-to-top').tooltip('show');
        
});

function removeCss() {
	$('#cssClass').removeClass('error');
	$('#cssClass').removeClass('success');
}
function displayMessage(cssClass, message) {
	var header = '';
	if('error' === cssClass) {
		header = 'Error!';
	} else {
		header = 'Success!';
	}
	$('#alertModal').find('.modal-title').text(header);
	removeCss();
	$('#cssClass').addClass(cssClass);
	$('#alertModal').find('.modal-body p').html(message);
	$('#alertModal').modal('show');
}

var castleApp = angular
.module("castleApp", [ 'ngResource']);

castleApp
.controller(
		'castleController',['$scope', '$http', '$resource', 
		                    function($scope, $http, $resource) {
			$scope.menu=true;
			$scope.footer = true;
			$scope.showAboutUs = false;
			$scope.showContact = false;
			$scope.showComRegis = false;
			$scope.showCloud = false;
			$scope.enquForm = {};
			$scope.isHome = true;
			$scope.showEve = false;
			$scope.eveEnquForm = {};

			var clear = function() {
				$scope.showAboutUs = false;
				$scope.showContact = false;
				$scope.showComRegis = false;
				$scope.showCloud = false;
				$scope.enquForm = {};
				$scope.isHome = false;
				$scope.showEve = false;
				$scope.eveEnquForm = {};
			}
			$scope.showAboutUsDetails = function() {
				clear();
				$scope.showAboutUs = true;
			}
			$scope.showHome = function() {
				clear();
				$scope.isHome = true;
			}
			$scope.showContactUs = function() {
				clear();
				$scope.showContact = true;
			}
			$scope.showCompul = function() {
				clear();
				$scope.showComRegis = true;
			}
			$scope.showCloudTel = function() {
				clear();
				$scope.showCloud = true;
			}
			$scope.sendEnquiryForm = function() {
				var enqObjForm = {
						name : $scope.enquForm.username,
						position : $scope.enquForm.position,
						companyName : $scope.enquForm.company,
						telephone : $scope.enquForm.telephone,
						emailAddress : $scope.enquForm.email,
						website : $scope.enquForm.website,
						modeOfContact : $scope.enquForm.mode,
						enquiringRelatedTo : $scope.enquForm.related,
						message: $scope.enquForm.msg
				};
				var enqForm = $http.post('/enquiry', enqObjForm);
				enqForm
				.success(function(data, status, headers, config) {
					if('success' === data.cssClass) {
						displayMessage(data.cssClass,data.msg);
					} else if('error' === data.cssClass) {
						displayMessage(data.cssClass,data.msg);
					}
					
				});
				enqForm.error(function(data, status, headers, config) {
					displayMessage("error","Your request could not be processed. Please try again later");
				});
			}
			$scope.showEventManag = function() {
				clear();
				$('.input-group.date').datepicker('show');
				$scope.showEve = true;
			}
			
			$scope.sendEventEnquiryForm = function() {
				var EenqObjForm = {
						name : $scope.eveEnquForm.username,
						eventType : $scope.eveEnquForm.etype,
						date : document.getElementById("edate").value,
						telephone : $scope.eveEnquForm.telephone,
						emailAddress : $scope.eveEnquForm.email,
						venue : $scope.eveEnquForm.venue,
						budget : $scope.eveEnquForm.budget,
						message: $scope.eveEnquForm.msg
				};
				var enqForm = $http.post('/enquiry/events', EenqObjForm);
				enqForm
				.success(function(data, status, headers, config) {
					if('success' === data.cssClass) {
						displayMessage(data.cssClass,data.msg);
					} else if('error' === data.cssClass) {
						displayMessage(data.cssClass,data.msg);
					}
					
				});
				enqForm.error(function(data, status, headers, config) {
					displayMessage("error","Your request could not be processed. Please try again later");
				});
			}
			$scope.showCalender = function() {
				$('.input-group.date').datepicker('show');
			}
			
		}]);