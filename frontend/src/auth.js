import { loginTeam } from "./api";

const auth = {
    isLoggedIn: () => {
        return localStorage.getItem("isLoggedIn");
    },
    login: (name) => {
        console.log("name : ", name);
        loginTeam(name).then((res) => {
            console.log("login : ", res);
            if (res?.length != 0) {
                alert("Logged in! Start Bidding!");
                localStorage.setItem("isLoggedIn", true);
                localStorage.setItem("team", JSON.stringify(res[0]));
                window.location.href = "/team";
            } else {
                alert("Login failed!");
            }
        });
    },
};

export default auth;
