/* eslint-disable jsx-a11y/img-redundant-alt */
const PlayerCard = ({ player }) => {
    return (
        <div className="p-2 col-2">
            <div class="card shadow">
                <img
                    className="card-img-top"
                    src={player.playerImageUrl}
                    alt="Card image cap"
                />
                <div className="card-body">
                    <h5 className="card-title">
                        {player.playerName.split(" ")[0]}
                        <br />
                        {player.playerName.split(" ")[1]}
                    </h5>
                </div>
                <div
                    className="d-flex flex-row p-2 w-100"
                    style={{ flexWrap: "wrap" }}
                >
                    <span className="badge alert-primary m-1">
                        Base : {player?.basePrice}
                    </span>
                    <span className="badge alert-secondary m-1">
                        Social : {player?.socialFollowing}
                    </span>
                    <span className="badge alert-info m-1">
                        Form : {player?.form}
                    </span>
                    <span className="badge alert-info m-1">
                        Record : {player?.previousRecord}
                    </span>
                    {player?.isSold ? (
                        <span className="badge alert-success m-1">Sold</span>
                    ) : (
                        <span className="badge alert-danger m-1">Unsold</span>
                    )}
                </div>
            </div>
        </div>
    );
};

export default PlayerCard;
