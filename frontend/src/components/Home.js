import { useState, useEffect } from "react";
import { getPlayers } from "../api";
import auth from "../auth";
import PlayerCard from "./common/PlayerCard";

const Home = () => {
    const [players, setPlayers] = useState([]);

    useEffect(() => {
        getPlayers().then((res) => {
            console.log("players : ", res);
            setPlayers(res);
        });
    }, []);

    return (
        <div
            style={{
                backgroundImage:
                    "url('https://www.iplt20.com/resources/v4.24.0/i/element-bgs/coloured_footer-bg-left.png')",
                backgroundRepeat: "no-repeat",
            }}
            className="customContainer"
        >
            <span className="d-flex">
                <div class="form-group mr-2">
                    <input
                        type="text"
                        class="form-control m-0"
                        id="teamName"
                        placeholder="Enter team name"
                    />
                </div>{" "}
                <span
                    className="btn btn-primary mr-2"
                    onClick={() => {
                        auth.login(document.getElementById("teamName").value);
                    }}
                >
                    Login Team
                </span>
                <a href="/player" className="btn btn-primary">
                    Add Player
                </a>
            </span>
            {players?.length > 0 ? (
                <div class="d-flex">
                    {players.map((player) => {
                        return <PlayerCard player={player} />;
                    })}
                </div>
            ) : null}
        </div>
    );
};

export default Home;
