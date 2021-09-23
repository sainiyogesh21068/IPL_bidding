import React, { useState, useEffect } from "react";
import { getBid, startBidding } from "../api";
import auth from "../auth";

const Team = () => {
    // const [isLoggedIn, setIsLoggedIn] = useState(false);

    useEffect(() => {
        if (!auth.isLoggedIn()) {
            window.location.href = "/home";
        }
        startBidding().then(() => {});

        getBid().then((res) => {
            console.log("bid : ", res);
        });
    }, []);

    return (
        <div className="customContainer">
            <div className="d-flex justify-content-center flex-column">
                <div className="d-flex justify-content-center">
                    <img
                        className=" img-fluid rounded"
                        src="https://static.iplt20.com/players/284/1.png"
                        // height="65%"
                    />
                </div>
                <div className="h4 text-center">M.S. Dhoni</div>
            </div>
            <div className="d-flex justify-content-center flex-column text-center h3">
                <span>Top Bid : CSK (1.5 Cr)</span>
                <span>Your Bid : 1.2 Cr</span>{" "}
            </div>
            <div className="d-flex justify-content-center text-center h3 mt-2">
                <span className="d-flex flex-row">
                    <div class="form-group mr-2">
                        <input
                            type="text"
                            class="form-control mt-0"
                            id="bidAmount"
                            aria-describedby="place bid"
                            placeholder="Enter bid amount"
                        />
                    </div>{" "}
                    <span className="btn btn-primary">Place Bid</span>
                </span>
            </div>
        </div>
    );
};

export default Team;
