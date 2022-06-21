var main = {


    init : function (){
        var _this = this;
       document.getElementById("btn_submit")?.addEventListener('click', function (){
            _this.save();
        });


        var btn_update = document.getElementById("btn_update");
        btn_update?.addEventListener('click',_this.update);


        var btn_delete = document.getElementById("btn_delete");
        btn_delete?.addEventListener('click',_this.delete);
    },

    save: function () {
        var _author = document.getElementById("author").value;
        var _desc  = document.getElementById("description").value;
        var params = {
            'author': _author,
            'description':_desc
        };
        const option = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(params),
        };

        fetch('http://localhost:8080/post/add',
            option)
            .then((response) => {
                return response.json();
            })
            .then((myJson) => {
                alert(JSON.stringify(myJson));
                location.href = "/";
                // location.href = 'http://localhost:8080/post/'+myJson.id;
            })
            .catch((error) => {
                console.log(error);
            });
    },

    update : function (){
        var _id = document.getElementById("id").value;
        var _author = document.getElementById("author").value;
        var _desc  = document.getElementById("description").value;
        var params = {
            'author': _author,
            'description':_desc
        };
        const option = {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(params),
        };

        fetch('http://localhost:8080/post/'+_id,
            option)
            .then((response) => {
                return response.json();
            })
            .then((myJson) => {
                alert(JSON.stringify(myJson));
                location.href = "/";
            })
            .catch((error) => {
                console.log(error);
            });
    },
    delete : function (){
        var _id = document.getElementById("id").value;
        const option = {
            method: "DELETE",
           body : _id
        };
        fetch('http://localhost:8080/post/'+_id,
            option)
            .then((response) => {
                return response.json();
            })
            .then((myJson) => {
                alert("성공적으로 삭제되었습니다.");
                location.href = "/";
            })
            .catch((error) => {
                console.log(error);
            });



    }
}

main.init();