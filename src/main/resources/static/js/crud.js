var main = {


    init : function (){
        var _this = this;
        var btn_action = document.getElementById("btn_submit");
        btn_action.addEventListener('click', function (){
            _this.submit();
        });

        console.log("init");
    },

    submit: function () {
        console.log("submit");
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
                location.href="/";
                return response.json();
            })
            .then((myJson) => {
                console.log(JSON.stringify(myJson));
            })
            .catch((error) => {
                console.log(error);
            });
    },
}

main.init();