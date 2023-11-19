/**
 * Represents the game board.
 * <br>
 * Generates the game board DOM inside the element named "boardWrap" when instantiated.
 * <br>
 * Provides the method {@link move} to facilitate gameplay, as well as methods {@link lock},
 * {@link unlock}, and {@link reset}. Does no logic checking internally; is only responsible
 * for the display of the game state.
 * <br>
 * All cells call method {@link clickedCell(boardRow, boardCol, cellRow, cellCol)} when clicked.
 */
 class GameBoard {
	
	constructor() {
		
		/**
		 * An array storing all the cell DOM objects generated for this game board
		 * @type {HTMLElement[][][][]}
		 */
		const allCells = [];
		
		/**
		 * An array storing all the small board DOM objects generated for this game board
		 * @type {HTMLElement[][]}
		 */
		const allBoards = [];
		
		/**
		 * Generate the playing board inside the DOM element titled "boardWrap".
		 */
		function genBoard() {
			
			/**
			 * Generates a 3x3 tic-tac-toe board
			 * @returns {HTMLElement} The board DOM element
			 * @param {number} a The row of this board in the larger board
			 * @param {number} b The column of this board in the larger board
			 */
			function genSmallBoard(a, b) {
				const wrap = document.createElement("DIV");
				
				const label = document.createElement("DIV");
				label.className = "boardLabel";
				wrap.appendChild(label);
				
				for (let i = 0; i < 3; i++) {
					allCells[a][b][i] = [];
					const row = document.createElement("DIV");
					for (let j = 0; j < 3; j++) {
						const cell = document.createElement("DIV");
						cell.className = "smallCell";
						//cell.id = `cell${a}-${b}-${i}-${j}`;
						cell.setAttribute("onclick", `clickedCell(${a},${b},${i},${j})`);
						
						const label = document.createElement("DIV");
						label.className = "cellLabel";
						cell.appendChild(label);
						
						row.appendChild(cell);
						allCells[a][b][i][j] = cell;
					}
					wrap.appendChild(row);
				}
				//wrap.id = `smallBoard${a}-${b}`;
				wrap.className = "smallBoard";
				
				return wrap;
			}
			
			const outerBoard = document.getElementById("boardWrap");
			
			for (let i = 0; i < 3; i++) {
				allCells[i] = [];
				allBoards[i] = [];
				const row = document.createElement("DIV");
				for (let j = 0; j < 3; j++) {
					allCells[i][j] = [];
					const cell = genSmallBoard(i, j);
					
					row.appendChild(cell);
					allBoards[i][j] = cell;
				}
				outerBoard.appendChild(row);
			}
			
			const restartBtnWrap = document.createElement("P");
			restartBtnWrap.style.padding = "50px 0";
			const restartBtn = document.createElement("A");
			restartBtn.textContent = "Restart";
			restartBtn.className = "BigButton";
			restartBtn.setAttribute("href", "/restartgame");
			restartBtnWrap.appendChild(restartBtn);
			outerBoard.appendChild(restartBtnWrap);
		}
		
		/**
		 * Marks a cell as belonging to a player
		 * @param {number} boardRow The row of the board
		 * @param {number} boardCol The column of the board
		 * @param {number} cellRow The row of the cell
		 * @param {number} cellCol The column of the cell
		 * @param {boolean} isX Whether the cell belongs to X (as opposed to O)
		 */
		function winCell(
			boardRow,
			boardCol,
			cellRow,
			cellCol,
			isX
		) {
			allCells[boardRow][boardCol][cellRow][cellCol].className =
				`smallCell ${isX ? 'xCell' : 'oCell'}`;
		}
		
		/**
		 * Marks a small board as belonging to a player
		 * @param {number} row The row of the board
		 * @param {number} col The column of the board
		 * @param {boolean|null} isX Whether the board belongs to X (as opposed to O),
		 *                           or null for a tie
		 */
		function winBoard(row, col, isX) {
			const label = allBoards[row][col].childNodes[0];
			label.style.transform = "rotateY(0deg)";
			label.style.background = isX ? "#b71540" : "#079992";
			label.textContent = isX ? "X" : "O";
			// noinspection JSIncompatibleTypesComparison
			if (isX === null) {
				// Handle ties
				label.style.background = "#f39c12";
				label.textContent = "–";
				label.style.alignItems = "initial";
				label.style.lineHeight = "100%";
			}
			
			for (let i = 1; i < allBoards[row][col].childNodes.length; i++) {
				const el = allBoards[row][col].childNodes[i];
				el.style.opacity = "0";
				el.style.pointerEvents = "none";
			}
		}
		
		/**
		 * Mark a board as the only board where a player can play.
		 * @param {number} row The row of the board
		 * @param {number} col The column of the board
		 */
		function markBoard(row, col) {
			for (let i = 0; i < 3; i++) {
				for (let j = 0; j < 3; j++) {
					allBoards[i][j].className =
						`smallBoard${row == i && col == j ? " yesPlay" : " noPlay"}`;
				}
			}
		}
		
		/**
		 * Mark all boards as valid plays.
		 */
		function clearMarkBoard() {
			for (let i = 0; i < 3; i++) {
				for (let j = 0; j < 3; j++) {
					allBoards[i][j].className = "smallBoard";
				}
			}
		}
		
		genBoard();
		
		/**
		 * Updates the board display given a newly updated game state after a player just moved.
		 *
		 * @param {boolean} originalTurn Which player just moved
		 * @param {GameState} state The game state post-move
		 * @param {number} boardRow The row of the board
		 * @param {number} boardCol The column of the board
		 * @param {number} cellRow The row of the cell
		 * @param {number} cellCol The column of the cell
		 */
		this.move = function (
			originalTurn,
			state,
			boardRow,
			boardCol,
			cellRow,
			cellCol
		) {
			// Mark the cell
			winCell(boardRow, boardCol, cellRow, cellCol, originalTurn);
			
			// If won the board, mark the board
			if (!Array.isArray(state.board[boardRow][boardCol])) {
				winBoard(boardRow, boardCol, state.board[boardRow][boardCol]);
			}
			
			// If game over, cleanup and bail
			if (state.status !== true) {
				clearMarkBoard();
				this.lockBoard();
				return;
			}
			
			// Restrict next board if needed
			if (state.lastMove !== null) {
				markBoard(state.lastMove[0], state.lastMove[1]);
			} else {
				clearMarkBoard();
			}
		};
		
		/**
		 * Lock the board from all player inputs until {@link unlockBoard} is called.
		 */
		this.lockBoard = function () {
			document.getElementById("boardWrap").className = "lockedBoard";
		};
		
		/**
		 * Unlock the board, allowing player inputs again. Has no effect unless {@link lockBoard}
		 * was called previously.
		 */
		this.unlockBoard = function () {
			document.getElementById("boardWrap").className = "";
		};
		
		/**
		 * Reset the board for a new game
		 */
		this.reset = function () {
			document.getElementById("boardWrap").innerHTML = "";
			genBoard();
			this.unlockBoard();
		}
	}
}