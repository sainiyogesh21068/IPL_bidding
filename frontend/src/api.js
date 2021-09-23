const BASE_URL = "http://localhost:8080";

export const getPlayers = async () => {
    let res = await fetch(BASE_URL + "/players/all", {
        method: "GET",
    });
    return res.json();
};
