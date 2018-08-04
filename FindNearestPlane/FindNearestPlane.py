'''
Calculates the closest plane to a certain location given the locations latitude and longitude.
'''

from opensky_api import OpenSkyApi
from math import *

EARTH_RADIUS = 6371

'''Calculates the distance between the location and a place using Euclidean Distance'''
def calculateEuclideanDistance(lat, lon, slat, slon):
	return sqrt((slat - lat)**2 + (slon - lon)**2)

'''Calculates the distance between the location and a place using Geodesic Distance'''
def calculateGeodesicDistance(lat, lon, slat, slon):
	absDiffOfLats = abs(lat - slat)
	absDiffOfLons = abs(lon - slon)

	return (2 * asin(sqrt(sin(absDiffOfLats/2)**2 + cos(lat) * cos(slat) * sin(absDiffOfLons/2)**2))) * EARTH_RADIUS

'''Iterates through all possibles planes, calculating the distance between the location and each plane. Returns
the information of the closest plane, and the Euclidean and Geodesic distances calculated.'''
def getClosestPlane(states, lat, lon):
	dist = 0
	geoDist = float('inf')
	stateVector = states.states[0]
	for s in states.states:
		if s.latitude is not None and s.longitude is not None:
			dist = calculateGeodesicDistance(radians(lat), radians(lon), radians(s.latitude), radians(s.longitude))
			if dist < geoDist:
				geoDist = dist
				stateVector = s
	euclidDist = calculateEuclideanDistance(lat, lon, stateVector.latitude, stateVector.longitude)
	return stateVector, geoDist, euclidDist

'''Prints plane information'''
def printInformation(s, geoDist, euclidDist):
	if geoDist is not None:
		print("Geodesic distance: " + str(geoDist))
	if euclidDist is not None:
		print("Euclidean distance: " + str(euclidDist))
	if s.callsign is not None:
		print("Call sign: " + str(s.callsign))
	if s.latitude is not None:
		print("Latitude: " + str(s.latitude))
	if s.longitude is not None:
		print("Longitude: " + str(s.longitude))
	if s.geo_altitude is not None:
		print("Geometric Altitude: " + str(s.geo_altitude))
	if s.origin_country is not None:
		print("Country of Origin: " + str(s.origin_country))
	if s.icao24 is not None:
		print("ICA024 ID: " + str(s.icao24))
	print("\n")

'''Runs program with given latitude and longitude of a location'''
def main(lat, lon):
	api = OpenSkyApi()
	states = api.get_states()
	s, geoDist, euclidDist = getClosestPlane(states, lat, lon)
	printInformation(s, geoDist, euclidDist)

print("Information on the nearest plane to the Eiffel Tower, where the latitude is 48.8584 and the longitude is 2.2945: ")
main(48.8584, 2.2945) #Eiffel Tower
print("Information on the nearest plane to JFK Airport, where the latitude is 40.6413 and the longitude is 73.7781: ")
main(40.6413, 73.7781) #JFK Airport