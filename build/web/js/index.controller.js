
function Index(){
    
    var me = this;
    
    this.button = $("#button")[0];
    
    this.alert = function(msg){
        alert(msg);
    };
    
    $(me.button).click(function (){
        me.alert("Hello World");
    });
   
}

(function(){ new Index(); })();