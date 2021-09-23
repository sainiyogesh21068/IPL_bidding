const auth = {
    isLoggedIn: (name) => {
        let flag=false

        if(!localStorage.getItem("isLoggedIn")){
                
                    

            
        //sample output of below fetch
        //    [
        //        {
        //             "name": "KKR",
        //             "id": 3
        //        }
        //    ]


        fetch('http://localhost:8080/findbyname?name='+name)
        .then(response => response.json())
        .then(d => { 
            console.log(d)
            console.log(d.length)
            if(d.length>0)
            {
                flag=true;
                localStorage.setItem("isLoggedIn",flag);
            }
        } );  

    }

        return flag; 
    }
}

export default auth