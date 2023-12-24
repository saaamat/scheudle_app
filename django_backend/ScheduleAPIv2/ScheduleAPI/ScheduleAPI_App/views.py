from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
from rest_framework.parsers import JSONParser
from django.http.response import JsonResponse

from .models import Descriptions, Events, Names, Profiles, ProfilesEvents
from .serializers import DescriptionSerializer, EventSerializer, NameSerializer, ProfileSerializer, ProfileEventSerializer

def index (request):
    return render(request, 'ScheduleAPI_App/index.html')

@csrf_exempt
def descriptionAPI(request):
    if request.method == 'GET':
        descriptions = Descriptions.objects.all()
        descriptions_serializer = DescriptionSerializer(descriptions, many = True)
        return JsonResponse(descriptions_serializer.data, safe = False, json_dumps_params={'ensure_ascii': False}, content_type = 'application/json; charset = utf-8')
    elif request.method == 'POST':
        description_data = JSONParser().parse(request)
        descriptions_serializer = DescriptionSerializer(data = description_data)
        if descriptions_serializer.is_valid():
            descriptions_serializer.save()
            return JsonResponse('POST successful', safe = False)
        return JsonResponse('POST failed', safe = False)

@csrf_exempt
def eventAPI(request):
    if request.method == 'GET':
        events = Events.objects.all()
        events_serializer = EventSerializer(events, many = True)
        return JsonResponse(events_serializer.data, safe = False, json_dumps_params={'ensure_ascii': False}, content_type = 'application/json; charset = utf-8')

@csrf_exempt
def nameAPI(request):
    if request.method == 'GET':
        names = Names.objects.all()
        names_serializer = NameSerializer(names, many = True)
        return JsonResponse(names_serializer.data, safe = False, json_dumps_params={'ensure_ascii': False}, content_type = 'application/json; charset = utf-8')
    elif request.method == 'POST':
        name_data = JSONParser().parse(request)
        names_serializer = NameSerializer(data = name_data)
        if names_serializer.is_valid():
            names_serializer.save()
            return JsonResponse('POST successful', safe = False)
        return JsonResponse('POST failed', safe = False)

@csrf_exempt
def profileAPI(request):
    if request.method == 'GET':
        profiles = Names.objects.all()
        profiles_serializer = ProfileSerializer(profiles, many = True)
        return JsonResponse(profiles_serializer.data, safe = False, json_dumps_params={'ensure_ascii': False}, content_type = 'application/json; charset = utf-8')
    elif request.method == 'POST':
        profile_data = JSONParser().parse(request)
        profiles_serializer = ProfileSerializer(data = profile_data)
        if profiles_serializer.is_valid():
            profiles_serializer.save()
            return JsonResponse('POST successful', safe = False)
        return JsonResponse('POST failed', safe = False)

@csrf_exempt
def profileeventAPI(request):
    if request.method == 'GET':
        profilesevents = ProfilesEvents.objects.all()
        profilesevents_serializer = ProfileEventSerializer(profilesevents, many = True)
        return JsonResponse(profilesevents_serializer.data, safe = False, json_dumps_params={'ensure_ascii': False}, content_type = 'application/json; charset = utf-8')