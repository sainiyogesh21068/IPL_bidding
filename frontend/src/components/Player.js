import "../styles/player.css";
import { useState } from "react";
import { addPlayer } from "../api";

const Player = () => {
    const [formData, setformData] = useState({
        playerName: "",
        playerImageUrl: "",
        socialFollowing: "",
        previousRecord: "",
        form: "",
        type: "",
        basePrice: "",
    });

    const updateFormData = (event) => {
        const target = event.target;
        const value =
            target.type === "checkbox" ? target.checked : target.value;
        const name = target.name;
        var temp_data = Object.assign({}, formData, { [name]: value });
        setformData(temp_data);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        addPlayer(formData).then((res) => {
            console.log("add player : ", res);
            alert(
                res === true
                    ? "Player Added Successfully"
                    : "Couldn't Add Player, Something went wrong"
            );
            console.log("add player : ", res);
        });
        setformData({
            playerName: "",
            playerImageUrl: "",
            socialFollowing: "",
            previousRecord: "",
            form: "",
            type: "",
            basePrice: "",
        });
    };

    return (
        <div id="wrapper">
            <div id="subscribeBox">
                <p></p>
                <form
                    className="subscribeForm"
                    name="Subscription Form"
                    method="post"
                    encType="text/plain"
                    onSubmit={handleSubmit}
                >
                    <input
                        id="fname"
                        type="text"
                        placeholder="Player Name"
                        name="playerName"
                        value={formData.playerName}
                        onChange={updateFormData}
                        required
                    />
                    <input
                        id="img_url"
                        type="text"
                        placeholder="Player Image Url"
                        name="playerImageUrl"
                        value={formData.playerImageUrl}
                        onChange={updateFormData}
                        required
                    />
                    <input
                        id="social"
                        type="number"
                        placeholder="Social following"
                        name="socialFollowing"
                        value={formData.socialFollowing}
                        onChange={updateFormData}
                        required
                    />
                    <input
                        id="record"
                        type="number"
                        placeholder="Previous Record"
                        name="previousRecord"
                        value={formData.previousRecord}
                        onChange={updateFormData}
                    />
                    <input
                        id="form"
                        type="number"
                        placeholder="Current Form"
                        name="form"
                        value={formData.form}
                        onChange={updateFormData}
                    />
                    <input
                        id="base"
                        type="text"
                        placeholder="Base Price"
                        name="basePrice"
                        value={formData.basePrice}
                        onChange={updateFormData}
                    />
                    <input
                        id="type"
                        type="text"
                        placeholder="Type"
                        name="type"
                        value={formData.type}
                        onChange={updateFormData}
                    />
                    <input id="submit" type="submit" value="Send" />
                </form>
            </div>
        </div>
    );
};

export default Player;
