const Navbar = () => {
    return (
        <nav
            class="navbar navbar-light shadow"
            style={{ backgroundColor: "#061d42" }}
        >
            <a class="navbar-brand" href="/home">
                <img
                    src="https://i.ibb.co/Ph7MsSp/s3-news-tmp-116020-ipl-default-1280-removebg-preview-1.png"
                    height="30"
                    className="d-inline-block align-top"
                    alt=""
                />
                <span className="h4 ml-2 text-white">&nbsp; AUCTION</span>
            </a>
        </nav>
    );
};

export default Navbar;
