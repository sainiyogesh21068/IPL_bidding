const BASE_URL = "http://localhost:8081";

export const getPlayers = async () => {
    let res = await fetch(BASE_URL + "/players/all", {
        method: "GET",
    });
    return res.json();
};

export const addPlayer = async (playerData) => {
    let res = await fetch(BASE_URL + "/players/saveplayer", {
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        method: "POST",
        body: JSON.stringify(playerData),
    });
    return res.json();
};

export const loginTeam = async (name) => {
    let res = await fetch(BASE_URL + "/findbyname?name=" + name);
    return res.json();
};

export const startBidding = async () => {
    let res = await fetch(BASE_URL + "/startbidding");
    return res.json();
};

export const getBid = async () => {
    let res = await fetch(BASE_URL + "/getbidplayer");
    return res.json();
};
