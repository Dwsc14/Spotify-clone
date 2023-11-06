<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="static/css/paymentstyle.css" />
        <title>Payment</title>
    </head>

    <body>
        <div class="pricing-card">
            <p class="user" user-id="1698512358272-0a534254-9a56-4024-93e2-1d1f4a0750bc">User:</p>
            <div class="card-header">
                <div class="card-btn-parent">
                    <button price="60" id="basic-plan" class="active">Month</button>
                    <button price="120" id="standard-plan">Quarter</button>
                    <button price="180" id="premium-plan">Premium</button>
                    <div class="overlay"></div>
                </div>
            </div>
            <div class="card-body">
                <div id="card-basic-plan" class="active" data-price="$60">
                    <div class="card-plans">
                        <span class="plan-tag">Month</span>
                        <div class="card-plan">
                            <h3 class="plan-title">30 days</h3>
                            <h3 class="plan-price">$60</h3>
                        </div>
                    </div>
                    <div class="card-content">
                        <p>Package for occasional music listeners.</p>
                        <div class="card-lists">
                            <div class="card-list"><img src="https://rvs-pricing-card.vercel.app/tick.svg" alt="" />Remove ads.</div>
                            <div class="card-list"><img src="https://rvs-pricing-card.vercel.app/wrong.svg" alt="" />Listen to music offline.</div>
                        </div>
                    </div>
                </div>
                <div id="card-standard-plan" data-price="$120">
                    <div class="card-plans">
                        <span class="plan-tag">Quarter</span>
                        <div class="card-plan">
                            <h3 class="plan-title">90 days</h3>
                            <h3 class="plan-price">$120</h3>
                        </div>
                    </div>
                    <div class="card-content">
                        <p>Package for frequent music listeners</p>
                        <div class="card-lists">
                            <div class="card-list"><img src="https://rvs-pricing-card.vercel.app/tick.svg" alt="" />Remove ads.</div>
                            <div class="card-list"><img src="https://rvs-pricing-card.vercel.app/tick.svg" alt="" />Listen to music offline.</div>
                        </div>
                    </div>
                </div>
                <div id="card-premium-plan" data-price="$180">
                    <div class="card-plans">
                        <span class="plan-tag">Year</span>
                        <div class="card-plan">
                            <h3 class="plan-title">365 days</h3>
                            <h3 class="plan-price">$180</h3>
                        </div>
                    </div>
                    <div class="card-content">
                        <p>Package for music enthusiasts</p>
                        <div class="card-lists">
                            <div class="card-list"><img src="https://rvs-pricing-card.vercel.app/tick.svg" alt="" />Remove ads.</div>
                            <div class="card-list"><img src="https://rvs-pricing-card.vercel.app/tick.svg" alt="" />Listen to music offline.</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-button">
                <div id="paypal-button-container"></div>
            </div>
        </div>
        <script src="https://www.paypal.com/sdk/js?client-id=AdGkXh2U8KA3g8VCtvNPut_vLeoydtSnLyWWhZ89toTpy-chg8DDicrgaK9BtJQOot74rQJIayIdzkYr"></script>
        <script src="static/js/paymentscript.js"></script>
    </body>
</html>
