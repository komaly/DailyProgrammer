'''
For the function funnel, given two strings of letters, it determines whether the second can be 
made from the first by removing one letter. The remaining letters must stay in the same order.

For the function bonus, it finds all words from the enable1.txt that can be made by removing 
one letter from the string.
'''

require 'set'

#Determines whether the second string can be made from the first string by removing one letter. 
def funnel(original, changed)
	if changed.length != original.length - 1
		return false
	end

	(0...original.length).each do |i|
		tst = original[0...i] + original[i+1...original.length]
		if tst == changed
			return true
		end
	end

	return false

end

puts "Word Funnel: Determines if first string, after removing a character, is the same as the second string."

puts "Original word: leave, changed word: eave. Output -> "+ funnel("leave", "eave").to_s
puts "Original word: reset, changed word: rest. Output -> "+ funnel("reset", "rest").to_s
puts "Original word: dragoon, changed word: dragon. Output -> "+ funnel("dragoon", "dragon").to_s
puts "Original word: eave, changed word: leave. Output -> "+ funnel("eave", "leave").to_s
puts "Original word: sleet, changed word: lets. Output -> "+ funnel("sleet", "lets").to_s
puts "Original word: skiff, changed word: ski. Output -> "+ funnel("skiff", "ski") .to_s

puts ""

$loaded = File.readlines("enable1.txt")

#Finds all words from the enable1.txt that can be made by removing one letter from the string.
def bonus(text, b2 = false)
	out = Set[]
	(0...text.length).each do |i|
		tst = text[0...i] + text[i+1...text.length] + "\n"
		if $loaded.include? tst
			out.add(tst)
		end

		if out.length > 5 && b2
			return Set[]
		end
	end

	return out

end

def printOut(text, out)
	print text + ": "
	if out.length == 0
		print "NULL"
	else
		out.each do |x|
			print x.chomp + " "
		end
	end
	puts ""
end

puts "Bonus: Finds all words from given text file that can be made by removing one letter from the given string."
o1 = bonus("dragoon")
printOut("dragon", o1)

o2 = bonus("boats")
printOut("boats", o2)

o3 = bonus("affidavit")
printOut("affidavit", o3)
