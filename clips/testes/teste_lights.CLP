(defrule red-light
	(light red)
=>
	(printout t "Stop" crlf)
)
(defrule yellow-light
	(light yellow)
=>
	(printout t "Speed Up" crlf)
)
(defrule green-light
	(light green)
=>
	(printout t "Go" crlf)
)