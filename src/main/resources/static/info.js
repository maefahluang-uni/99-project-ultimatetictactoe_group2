/**
 * Represents the information box displayed to the player.
 */
 class InfoBox {
	constructor() {
		const wrap = document.getElementById("infoBox");
		const header = document.createElement("H2");
		const msg = document.createElement("P");
		
		wrap.append(header);
		wrap.appendChild(msg);
		
		/**
		 * Sets the displayed message with heading in the header and with msg in small text.
		 * Any occurrences of $X$ or $O$ in the heading are automatically colored appropriately.
		 *
		 * @param {string} heading
		 * @param {?string} message
		 */
		this.setMsg = function (heading, message) {
			// noinspection JSIncompatibleTypesComparison
			if (message === null) {
				msg.style.display = "none";
			} else {
				msg.style.display = "block";
				msg.innerHTML = message;
			}
			
			header.innerHTML = heading
				.replace("$X$", "<span style='color:#c0392b;'>X</span>")
				.replace("$O$", "<span style='color:#16a085;'>O</span>");
		};
	}
}