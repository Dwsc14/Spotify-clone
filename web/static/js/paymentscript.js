const planBtns = document.querySelectorAll(".card-btn-parent button");
const plans = document.querySelectorAll(".card-body > div");

var amount = 60;
var pack = "basic-plan";
var userElement = document.querySelector(".user");
var userid = userElement.getAttribute("user-id");

console.log(userid);

paypal
    .Buttons({
        createOrder: function (data, actions) {
            return actions.order.create({
                purchase_units: [
                    {
                        amount: {
                            value: amount,
                        },
                    },
                ],
                application_context: {
                    user: {
                        id: userid,
                        packs: pack,
                    },
                },
            });
        },
        onApprove: function (data, actions) {
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "payment", true);
            xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

            var dataToSend = {
                orderId: userid,
                pack: "completed",
            };
            xhr.send(JSON.stringify(dataToSend));
            window.location.href = "home";
        },
    })
    .render("#paypal-button-container");

planBtns.forEach((planBtn) => {
    planBtn.addEventListener("click", function () {
        removeClass();

        amount = this.getAttribute("price");
        pack = this.getAttribute("id");

        this.classList.add("active");
        let btnVal = this.getAttribute("id");
        let btnId = "#card-" + btnVal;
        document.querySelector(btnId).classList.add("active");
    });
});

function removeClass() {
    planBtns.forEach((planBtn) => {
        if (planBtn.classList.contains("active")) {
            planBtn.classList.remove("active");
        }
    });
    plans.forEach((plan) => {
        if (plan.classList.contains("active")) {
            plan.classList.remove("active");
        }
    });
}
