import "../styles/player.css";

const Player = () => {
    return (
        <div id="wrapper">
            <div id="subscribeBox">
                <p></p>

                <form
                    class="subscribeForm"
                    name="Subscription Form"
                    method="post"
                    enctype="text/plain"
                >
                    <input
                        id="fname"
                        type="text"
                        placeholder="Player Name"
                        Name="Name"
                        required
                    />
                    <input
                        id="lname"
                        type="text"
                        placeholder="Social following"
                        name="social"
                        required
                    />
                    <input
                        id="record"
                        type="text"
                        placeholder="Previous Record"
                        name="record"
                    />
                    <input
                        id="base"
                        type="text"
                        placeholder="Base Price"
                        name="base"
                    />
                    <input
                        id="type"
                        type="text"
                        placeholder="Type"
                        name="type"
                    />

                    <input id="submit" type="submit" value="Send" />
                </form>
            </div>
        </div>
    );
};

export default Player;
