
'''
This program takes shelves of different sizes and books of different widths,
and determines the least amount of shelves needed for all the books. If all 
the books cannot fit on the shelves, it outputs that it is Impossible.
'''

class BookShelves
	
	#Initializes sorted arrays of shelf sizes and book widths
	def initialize(fileName)
		@shelves = []
		@books = []
		File.open(fileName, "r") do |f|
			@shelves += f.readline.split()
			f.each_line do |line|
				@books << line.split()[0].to_i
	  		end
		end

		@shelves.map!{|b| b.to_i}

		@shelves.sort!{|x, y| y <=> x}
		@books.sort!{|x, y| y <=> x}

	end

	#Checks if it is impossible to put all the books up on the shelves
	def checkImpossibility
		return @books.inject(0){|sum,x| sum + x } > @shelves.inject(0){|sum,x| sum + x }
	end

	#Calculates the least amount of shelves needed for the given books
	def calculateNumberOfShelves
		if checkImpossibility
			puts "Impossible"
			return
		end

		countShelves = 1
		i = 0
		shelfSpace = @shelves[i]
		shelvesUsed = [shelfSpace]


		(0...@books.length).each do |b|
			shelfSpace = shelfSpace - @books[b]
			if b == @books.length - 1
				break
			end

			if shelfSpace < @books[b+1]
				i += 1
				shelfSpace = @shelves[i]
				shelvesUsed << shelfSpace
				countShelves += 1
			end
		end

		puts "#{countShelves} shelves are bought: #{shelvesUsed}"
		return countShelves
	
	end


end

b1 = BookShelves.new("input1.txt")
#b1.calculateNumberOfShelves

b2 = BookShelves.new("input2.txt")
#b2.calculateNumberOfShelves

b3 = BookShelves.new("input3.txt")
b3.calculateNumberOfShelves


