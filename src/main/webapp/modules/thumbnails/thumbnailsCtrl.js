app.controller('ThumbnailsCtrl', ['$scope', '$http',  function ($scope, $http){

   /** $scope.files = {
        "documentList": [
            {
                "documentName": "KF",
                "range": "1",
                "typeDocument": "fol",
                "filesList": [
                    {}
                ]
            },
            {
                "documentName": "SG",
                "range": "2",
                "typeDocument": "fol",
                "filesList": [
                    {}
                ]
            },
            {
                "documentName": "PDF",
                "range": "3",
                "documentUrl": "http://www.bilans-ges.ademe.fr/static/documents/conditions_juridiques.pdf",
                "typeDocument": "pdf"
            },
            {
                "documentName": "Excel",
                "range": "4",
                "documentUrl": "http://opendatakit.org/wp-content/uploads/static/sample.xls",
                "typeDocument": "exc"
            },
            {
                "documentName": "Word",
                "range": "5",
                "documentUrl": "https://www.google.fr/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&cad=rja&uact=8&ved=0CCkQFjABahUKEwjYiOz9tf3GAhVHOxQKHe6TDPQ&url=http%3A%2F%2Fwww.ewh.ieee.org%2Ftc%2Fits%2FSOLI08%2Fsample.doc&ei=LD-3VdjCN8f2UO6nsqAP&usg=AFQjCNFx9NzQ-7SNldDPTOFw2RrYAwCFZA&sig2=s6905dO5mIZRj7r_yFZN7A&bvm=bv.98717601,d.ZGU",
                "typeDocument": "wor"
            },
            {
                "documentName": "POWERPOINT",
                "range": "6",
                "documentUrl": "https://www.google.fr/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&sqi=2&ved=0CCEQFjAAahUKEwi9nPKntv3GAhVMuBQKHTEHB1g&url=http%3A%2F%2Fwww.sraticongres.ro%2Fdownload-files%2FuPoGPpb.ppt&ei=hT-3Vf3FBczwUrGOnMAF&usg=AFQjCNFjZxgEyKFexU7WPaey11FOv037kg&sig2=L9L16UuNOVM0I7Ocg3k6bQ&bvm=bv.98717601,d.ZGU",
                "typeDocument": "pwp"
            },
            {
                "documentName": "PDF",
                "range": "3",
                "documentUrl": "http://www.bilans-ges.ademe.fr/static/documents/conditions_juridiques.pdf",
                "typeDocument": "pdf"
            },
            {
                "documentName": "Excel",
                "range": "4",
                "documentUrl": "http://opendatakit.org/wp-content/uploads/static/sample.xls",
                "typeDocument": "exc"
            },
            {
                "documentName": "Word",
                "range": "5",
                "documentUrl": "https://www.google.fr/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&cad=rja&uact=8&ved=0CCkQFjABahUKEwjYiOz9tf3GAhVHOxQKHe6TDPQ&url=http%3A%2F%2Fwww.ewh.ieee.org%2Ftc%2Fits%2FSOLI08%2Fsample.doc&ei=LD-3VdjCN8f2UO6nsqAP&usg=AFQjCNFx9NzQ-7SNldDPTOFw2RrYAwCFZA&sig2=s6905dO5mIZRj7r_yFZN7A&bvm=bv.98717601,d.ZGU",
                "typeDocument": "wor"
            },
            {
                "documentName": "POWERPOINT",
                "range": "6",
                "documentUrl": "https://www.google.fr/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&sqi=2&ved=0CCEQFjAAahUKEwi9nPKntv3GAhVMuBQKHTEHB1g&url=http%3A%2F%2Fwww.sraticongres.ro%2Fdownload-files%2FuPoGPpb.ppt&ei=hT-3Vf3FBczwUrGOnMAF&usg=AFQjCNFjZxgEyKFexU7WPaey11FOv037kg&sig2=L9L16UuNOVM0I7Ocg3k6bQ&bvm=bv.98717601,d.ZGU",
                "typeDocument": "pwp"
            }
            ,
            {
                "documentName": "PDF",
                "range": "3",
                "documentUrl": "http://www.bilans-ges.ademe.fr/static/documents/conditions_juridiques.pdf",
                "typeDocument": "pdf"
            },
            {
                "documentName": "Excel",
                "range": "4",
                "documentUrl": "http://opendatakit.org/wp-content/uploads/static/sample.xls",
                "typeDocument": "exc"
            },
            {
                "documentName": "Word",
                "range": "5",
                "documentUrl": "https://www.google.fr/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&cad=rja&uact=8&ved=0CCkQFjABahUKEwjYiOz9tf3GAhVHOxQKHe6TDPQ&url=http%3A%2F%2Fwww.ewh.ieee.org%2Ftc%2Fits%2FSOLI08%2Fsample.doc&ei=LD-3VdjCN8f2UO6nsqAP&usg=AFQjCNFx9NzQ-7SNldDPTOFw2RrYAwCFZA&sig2=s6905dO5mIZRj7r_yFZN7A&bvm=bv.98717601,d.ZGU",
                "typeDocument": "wor"
            },
            {
                "documentName": "POWERPOINT",
                "range": "6",
                "documentUrl": "https://www.google.fr/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&sqi=2&ved=0CCEQFjAAahUKEwi9nPKntv3GAhVMuBQKHTEHB1g&url=http%3A%2F%2Fwww.sraticongres.ro%2Fdownload-files%2FuPoGPpb.ppt&ei=hT-3Vf3FBczwUrGOnMAF&usg=AFQjCNFjZxgEyKFexU7WPaey11FOv037kg&sig2=L9L16UuNOVM0I7Ocg3k6bQ&bvm=bv.98717601,d.ZGU",
                "typeDocument": "pwp"
            },
            {
                "documentName": "PDF",
                "range": "3",
                "documentUrl": "http://www.bilans-ges.ademe.fr/static/documents/conditions_juridiques.pdf",
                "typeDocument": "pdf"
            },
            {
                "documentName": "Excel",
                "range": "4",
                "documentUrl": "http://opendatakit.org/wp-content/uploads/static/sample.xls",
                "typeDocument": "exc"
            },
            {
                "documentName": "Word",
                "range": "5",
                "documentUrl": "https://www.google.fr/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&cad=rja&uact=8&ved=0CCkQFjABahUKEwjYiOz9tf3GAhVHOxQKHe6TDPQ&url=http%3A%2F%2Fwww.ewh.ieee.org%2Ftc%2Fits%2FSOLI08%2Fsample.doc&ei=LD-3VdjCN8f2UO6nsqAP&usg=AFQjCNFx9NzQ-7SNldDPTOFw2RrYAwCFZA&sig2=s6905dO5mIZRj7r_yFZN7A&bvm=bv.98717601,d.ZGU",
                "typeDocument": "wor"
            },
            {
                "documentName": "POWERPOINT",
                "range": "6",
                "documentUrl": "https://www.google.fr/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&sqi=2&ved=0CCEQFjAAahUKEwi9nPKntv3GAhVMuBQKHTEHB1g&url=http%3A%2F%2Fwww.sraticongres.ro%2Fdownload-files%2FuPoGPpb.ppt&ei=hT-3Vf3FBczwUrGOnMAF&usg=AFQjCNFjZxgEyKFexU7WPaey11FOv037kg&sig2=L9L16UuNOVM0I7Ocg3k6bQ&bvm=bv.98717601,d.ZGU",
                "typeDocument": "pwp"
            }
        ]
    };*/
    
    $scope.initList = function(rootName) {
    	$http.get('/drive/list?' + 'rootName=' + rootName).
	        success(function(data, status) {
	          console.log("success thumbnails: " + status);
	          $scope.files = data;
	        }).
	        error(function(error, status) {
		          console.log("error thumbnails: " + status);
	        });
    }
}]);