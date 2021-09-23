import { useEffect } from "react";
import { getPlayers } from "../api";

const Home = () => {
    useEffect(() => {
        getPlayers().then((res) => {
            console.log("players : ", res);
        });
    }, []);
    return (
        <div
            style={{
                backgroundImage:
                    "url('https://www.iplt20.com/resources/v4.24.0/i/element-bgs/coloured_footer-bg-left.png')",
                backgroundRepeat: "no-repeat",
                // backgroundColor: "#061d42",
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
                <span className="btn btn-primary mr-2">Login Team</span>
                <a href="/player" className="btn btn-primary">
                    Add Player
                </a>
            </span>
        </div>
    );
};

export default Home;
