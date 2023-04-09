document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");

    form.addEventListener("submit", function (event) {
        const usernameInput = document.getElementById("username");
        const passwordInput = document.getElementById("password");

        if (usernameInput.value === "" || passwordInput.value === "") {
            alert("Please fill in all fields.");
            event.preventDefault();
        }
    });
});
