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
